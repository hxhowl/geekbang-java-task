package com.demo.oauth2.controller;

import com.demo.oauth2.constant.OauthGiteeConst;
import com.demo.oauth2.entity.User;
import com.demo.oauth2.utils.HttpUtils;
import com.google.gson.Gson;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * @author hxhowl
 * @since 2021/4/21
 */
public class OauthController {


    /**
     * web初始化，可以将路由放在这里
     */
    public static void init() {
        get("/", toIndex);
        get("/oauth/redirect", oauth);
        post("/user/getInfo", getInfo);
    }

    /**
     * 转跳到index页面
     */
    public static Route toIndex = (request, response) -> {
        response.cookie("passkey", "yes");    //过滤，防止用户恶意访问资源
        response.redirect("/index.html");
        return null;
    };

    /**
     * 完成OAuth认证，获取授权码,并用授权码获取令牌
     */
    public static Route oauth = (request, response) -> {
        OauthGiteeConst.userCode = request.queryParams("code");                      //从URL中获取授权码
        OauthGiteeConst.token =
                HttpUtils.tokenResponse(OauthGiteeConst.userCode);   //使用授权码获取到token令牌
        response.redirect("/welcome.html");
        return null;
    };

    /**
     * 获取Gitee的用户信息
     */
    public static Route getInfo = (request, response) -> {
        User user =
                HttpUtils.giteeInfo(OauthGiteeConst.token.getAccessToken());    //使用token获取Gitee的用户信息
        return new Gson().toJson(user);
    };
}
