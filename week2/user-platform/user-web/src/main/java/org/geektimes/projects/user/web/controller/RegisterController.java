package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.projects.user.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Set;

/**
 * @author hxhowl
 * @since 2021/3/9
 */
@Path("/register")
public class RegisterController implements PageController {

    private UserService userService = new UserServiceImpl();

    private Validator validator;

//    @Resource(name = "bean/UserService")
//    private UserService userService;

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

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()){
            final String[] msg = {""};
            violations.forEach(c -> {
                msg[0] += c.getMessage();
                msg[0] +="; ";
            });
            request.setAttribute("Message", msg[0]);
            return "index.jsp";
        }

        if (userService.getByName(name) == null) {
            userService.register(user);
            request.setAttribute("Login_Name", name);
        } else {
            request.setAttribute("Error_Message","Register Failed, username " +
                    "already exists");
        }
        return "index.jsp";
    }
}
