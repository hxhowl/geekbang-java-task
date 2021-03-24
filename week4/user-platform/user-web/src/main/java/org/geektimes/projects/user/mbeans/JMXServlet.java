package org.geektimes.projects.user.mbeans;

import javax.management.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : hxhowl
 * @create 2021/3/15 17:36
 */
public class JMXServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("enter--doGet");
        super.doGet(req, resp);
        System.out.println("exit--doGet");
    }

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("enter--init");
        super.init();
        MBeanServer server = MBeanServerFactory.createMBeanServer("com.ilxlf.jmx.common");
        ObjectName configuration =  null;
        try {
            configuration = new ObjectName("com.ilxlf.jmx.common=NewValue");
            server.registerMBean(new Configuration(), configuration);
        } catch (MalformedObjectNameException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MBeanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("exit--init");
    }

}
