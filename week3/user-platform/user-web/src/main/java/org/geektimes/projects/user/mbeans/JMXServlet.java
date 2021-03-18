package org.geektimes.projects.user.mbeans;

import javax.management.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author chenpeng.huang
 * @since 2021-03-17
 */
public class JMXServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doget in");
        super.doGet(req, resp);
        System.out.println("doget out");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init in");
        super.init();
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName configuration = null;
        try {
            configuration = new ObjectName("jolokia:type=servlet,name=test");
            server.registerMBean(new Configuration(), configuration);

        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }

        System.out.println("init out");
    }
}
