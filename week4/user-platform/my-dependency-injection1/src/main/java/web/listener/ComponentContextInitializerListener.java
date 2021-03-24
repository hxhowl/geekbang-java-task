package web.listener;

import component.context.ComponentContext;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Field;

/**
 * {@link ComponentContext} 初始化器
 * ContextLoaderListener
 */
public class ComponentContextInitializerListener implements ServletContextListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
        ConfigProviderResolver configProviderResolver = ConfigProviderResolver.instance();
        ClassLoader classLoader = null;
        for(Field declaredField:servletContext.getClass().getDeclaredFields()){
            if(declaredField.getType().equals(ServletContext.class)){
                declaredField.setAccessible(true);
                try {
                    ServletContext servletContext1 = (ServletContext)declaredField.get(servletContext);
                    classLoader = servletContext1.getClassLoader();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        Config config = configProviderResolver.getConfig(classLoader);
        System.out.println(config);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ComponentContext component.context = ComponentContext.getInstance();
//        component.context.destroy();
    }

}
