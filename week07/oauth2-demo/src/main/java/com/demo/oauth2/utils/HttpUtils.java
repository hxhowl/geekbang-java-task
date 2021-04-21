package com.demo.oauth2.utils;

import com.demo.oauth2.constant.OauthGiteeConst;
import com.demo.oauth2.entity.Token;
import com.demo.oauth2.entity.User;
import com.google.gson.Gson;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author hxhowl
 * @since 2021/4/21
 */
public class HttpUtils {
    /**
     * 使用授权码获取令牌
     *
     * @param code 授权码
     * @return 返回token令牌
     * @throws IOException
     */
    public static Token tokenResponse(String code) throws IOException {
        String content = Request.post(OauthGiteeConst.giteeURL(code))
                .execute().returnContent().toString();
        Token token = new Gson().fromJson(content, Token.class);
        return token;
    }

    /**
     * 查询用户信息
     *
     * @param accessToken
     * @return
     * @throws IOException
     */
    public static User giteeInfo(String accessToken) throws IOException {
        String content = Request.get(OauthGiteeConst.userInfo(accessToken))
                .execute().returnContent().asString(UTF_8);
        return new Gson().fromJson(content, User.class);
    }
}
