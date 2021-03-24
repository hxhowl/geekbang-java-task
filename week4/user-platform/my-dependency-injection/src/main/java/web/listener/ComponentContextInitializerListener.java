package web.listener;

import component.context.ComponentContext;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
        Config config = configProviderResolver.getConfig();
        System.out.println(config);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ComponentContext component.context = ComponentContext.getInstance();
//        component.context.destroy();
    }

}
