//package web.listener;
//
//import org.geektimes.component.context.ComponentContext;
//import org.geektimes.projects.user.domain.User;
//import org.geektimes.projects.user.sql.DBConnectionManager;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import java.util.logging.Logger;
//
///**
// * 测试用途
// */
//@Deprecated
//public class TestingListener implements ServletContextListener {
//
//    private Logger logger = Logger.getLogger(this.getClass().getName());
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
////        ComponentContext component.context = ComponentContext.getInstance();
////        DBConnectionManager dbConnectionManager = component.context.getComponent("bean/DBConnectionManager");
////        dbConnectionManager.getConnection();
////        testPropertyFromServletContext(sce.getServletContext());
////        testPropertyFromJNDI(component.context);
////        testUser(dbConnectionManager.getEntityManager());
////        logger.info("所有的 JNDI 组件名称：[");
////        component.context.getComponentNames().forEach(logger::info);
////        logger.info("]");
//    }
//
//    private void testPropertyFromServletContext(ServletContext servletContext) {
//        String propertyName = "application.name";
//        logger.info("ServletContext Property[" + propertyName + "] : "
//                + servletContext.getInitParameter(propertyName));
//    }
//
//    private void testPropertyFromJNDI(ComponentContext component.context) {
//        String propertyName = "maxValue";
//        logger.info("JNDI Property[" + propertyName + "] : "
//                + component.context.lookupComponent(propertyName));
//    }
//
//    private void testUser(EntityManager entityManager) {
//        User user = new User();
//        user.setName("小马哥");
//        user.setPassword("******");
//        user.setEmail("mercyblitz@gmail.com");
//        user.setPhoneNumber("abcdefg");
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(user);
//        transaction.commit();
//        System.out.println(entityManager.find(User.class, user.getId()));
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//    }
//
//}
