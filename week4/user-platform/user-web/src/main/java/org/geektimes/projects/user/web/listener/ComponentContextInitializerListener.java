//package org.geektimes.projects.user.web.listener;
//
//import org.geektimes.component.context.ComponentContext;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//
///**
// * {@link ComponentContext} 初始化器
// * ContextLoaderListener
// */
//public class ComponentContextInitializerListener implements ServletContextListener {
//
//    private ServletContext servletContext;
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        this.servletContext = sce.getServletContext();
//        ComponentContext component.context = new ComponentContext();
//        component.context.init(servletContext);
////        ConfigProviderResolver configProviderResolver = ConfigProviderResolver.instance();
////        Config config = configProviderResolver.getConfig();
////        System.out.println(config);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
////        ComponentContext component.context = ComponentContext.getInstance();
////        component.context.destroy();
//    }
//
//}
