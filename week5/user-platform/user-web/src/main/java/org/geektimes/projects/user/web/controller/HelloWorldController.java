package org.geektimes.projects.user.web.controller;

import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.InputStreamReader;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/hello")
public class HelloWorldController implements PageController {

//    @GET
//    @POST
//    @Path("/world") // /hello/world -> HelloWorldController
//    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//        return "index.jsp";
//    }


    @GET
    @Path("/world") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "123";
    }

    @POST
    @Path("/world1") // /hello/world -> HelloWorldController
    public String execute1(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream(),"utf-8");
        String value = "";
        int ch;
        while((ch = inputStreamReader.read())!= -1){
            value += (char)ch;
        }
        return value;
    }
}
