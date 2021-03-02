package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author hxhowl
 * @since 2021/3/2
 */
@Path("")
public class RegisterSubmitController implements PageController {

    @POST
    @Path("/registerSubmit")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User();
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        UserService userService = new UserServiceImpl();
        User user1 = userService.queryUserByNameAndPassword(user.getName(),
                user.getPassword());
        if (user1 == null){
            userService.register(user);
            User user2 = userService.queryUserByNameAndPassword(user.getName(),
                    user.getPassword());

            return "registerSuccess.jsp";
        }else {
            return "register.jsp";
        }
    }
}
