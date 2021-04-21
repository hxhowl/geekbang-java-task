package com.demo.oauth2;

import com.demo.oauth2.controller.OauthController;

import static spark.Spark.*;
import static spark.Spark.halt;

/**
 * @author hxhowl
 * @since 2021/4/21
 */
public class Main {
    public static void main(String[] args) {
        port(8088);
        staticFiles.location("/public");
        after((request, response) -> {
            if (request.cookie("passkey") == null) {
                halt(401, "You are not welcome here");  //过滤，防止用户恶意访问资源
            }
            response.header("Content-Type", "text/html;charset=UTF-8");
        });
        OauthController.init();
        System.out.println("success,please click http://localhost:8088 to start!");
    }
}
