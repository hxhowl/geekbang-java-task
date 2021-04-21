package com.demo.oauth2.constant;

import com.demo.oauth2.entity.Token;

/**
 * @author hxhowl
 * @since 2021/4/21
 */
public class OauthGiteeConst {
    public final static String CLIENT_ID = "b16b53ae72ae60f21f0492a2c1ef0d206287c94fa8323b257423141d405bac2d";

    public final static String CLIENT_SECRET = "2e9034d68b81020b09aba832c40555409b6f07db4090479202175f06b2ae7652";

    public final static String REDIRECT_URI = "http://localhost:8088/oauth/redirect";

    /**
     * 用户授权码
     */
    public static String userCode = null;

    /**
     * 令牌
     */
    public static Token token = null;

    /**
     * @param code 用户授权授权码
     * @return 该URL地址可以获取令牌
     */
    public static String giteeURL(String code) {
        return "https://gitee.com/oauth/token?" +
                "grant_type=authorization_code" +
                "&code=" + code +
                "&client_id=" + CLIENT_ID +
                "&redirect_uri=" + REDIRECT_URI +
                "&client_secret=" + CLIENT_SECRET;
    }

    /**
     * 获取用户信息
     *
     * @param accessToken
     * @return
     */
    public static String userInfo(String accessToken) {
        return "https://gitee.com/api/v5/user?access_token=" + accessToken;
    }

}
