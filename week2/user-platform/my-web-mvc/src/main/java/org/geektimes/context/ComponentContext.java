package org.geektimes.context;

import org.geektimes.projects.user.web.mvc.controller.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.naming.*;
import javax.servlet.ServletContext;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author hxhowl
 * @since 2021/3/10
 */
public class ComponentContext {
    public static final String CONTEXT_NAME = ComponentContext.class.getName();

    private static ServletContext servletContext;

    private Context context;

    private Map<String, Object> componentsName = new LinkedHashMap<>();

    private List<Controller> controllers = new ArrayList<>();

    public static ComponentContext getInstance() {
        return (ComponentContext) servletContext.getAttribute(CONTEXT_NAME);
    }


    public void init(ServletContext servletContext) {
        servletContext.setAttribute(CONTEXT_NAME, this);
        this.servletContext = servletContext;

        //初始化环境上下文
        initEnvContext();
        //实例化组件
        instantiateComponent();
        //初始化组件
        initializeComponent();
    }

    /**
     * 初始化组件（支持Java 标准 Commons Annotation 生命周期）
     * <ol>
     *     <li>注入阶段 - {@link javax.annotation.Resource}</li>
     *     <li>初始阶段 - {@link javax.annotation.PostConstruct}</li>
     *     <li>销毁阶段 - {@link javax.annotation.PreDestroy}</li>
     * </ol>
     */
    private void initializeComponent() {
        componentsName.values().forEach(component -> {
            //注入阶段
            injectComponents(component);
            //初始化阶段
            processPostConstruct(component);
            //销毁阶段
            processPreDestroy(component);
        });
    }

    private void injectComponents(Object component) {
        Arrays.stream(component.getClass().getDeclaredFields())
                .filter(field -> {
                    return !Modifier.isStatic(field.getModifiers()) &&
                            field.isAnnotationPresent(Resource.class);
                }).forEach(field -> {
            Resource resource = field.getAnnotation(Resource.class);
            String name = resource.name();
            field.setAccessible(true);
            Object injectedObject = getComponent(name);
            try {
                //注入目标对象
                field.set(component, injectedObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private void processPreDestroy(Object component) {
        //TODO
    }

    private void processPostConstruct(Object component) {
        Stream.of(component.getClass().getMethods())
                .filter(method -> {
                    return !Modifier.isStatic(method.getModifiers()) &&
                            method.getParameterCount() == 0 &&
                            method.isAnnotationPresent(PostConstruct.class);
                }).forEach(method -> {
            try {
                // 执行目标方法
                method.invoke(component);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void instantiateComponent() {
        //从jndi中查找所有JavaBean的名称
        List<String> componentNames = listComponentName("/");
        //通过依赖查找初始化JavaBean
        componentNames.forEach(componentName -> {
            Object component = lookupComponent(componentName);
            componentsName.put(componentName, component);
            if (component instanceof Controller) {
                //如果component实现了Controller接口，则放入controllers集合中
                controllers.add((Controller) component);
            }
        });
    }

    private List<String> listComponentName(String name) {
        try {
            List<String> componentsName = null;
            NamingEnumeration<NameClassPair> list = context.list(name);

            if (!list.hasMoreElements()) {
                return Collections.EMPTY_LIST;
            }

            componentsName = new ArrayList<>();
            while (list.hasMoreElements()) {
                NameClassPair next = list.nextElement();
                String className = next.getClassName();
                Class<?> targetClass = getClass().getClassLoader().loadClass(className);
                if (Context.class.isAssignableFrom(targetClass)) {
                    componentsName.addAll(listComponentName(next.getName()));
                } else {
                    String fullName = name.startsWith("/") ? next.getName() : name + "/" + next.getName();
                    componentsName.add(fullName);
                }
            }
            return componentsName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void initEnvContext() {
        try {
            context = (Context) new InitialContext().lookup("java:/comp/env");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对外依赖查找
     *
     * @param name
     * @param <C>
     * @return
     */
    public <C> C getComponent(String name) {
        return (C) componentsName.get(name);
    }

    /**
     * 对内依赖查找
     *
     * @param name
     * @param <C>
     * @return
     */
    public <C> C lookupComponent(String name) {
        try {
            return (C) context.lookup(name);
        } catch (NamingException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }


    public void destroy() {
        if (context != null) {
            try {
                context.close();
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public List<Controller> getControllers() {
        return controllers;
    }
}
