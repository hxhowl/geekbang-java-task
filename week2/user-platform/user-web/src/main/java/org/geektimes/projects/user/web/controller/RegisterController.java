package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.projects.user.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author hxhowl
 * @since 2021/3/9
 */
@Path("/register")
public class RegisterController implements PageController {

    private UserService userService = new UserServiceImpl();

    @GET
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        if (request.getMethod().equalsIgnoreCase(HttpMethod.POST)) {
            return doPost(request,response);
        }
        return "register-form.jsp";
    }
    private String doPost(HttpServletRequest request,
                          HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);


        if (userService.getByName(name)!= null) {
            userService.register(user);
            request.setAttribute("Login_Name", name);
        } else {
            request.setAttribute("Error_Message","Register Failed, username " +
                    "already exists");
        }
        return "index.jsp";
    }
}
