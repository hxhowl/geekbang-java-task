package com.demo.oauth2.entity;

/**
 * @author hxhowl
 * @since 2021/4/21
 */
public class User {
    private Integer id;
    private String login;
    private String name;
    private String htmlUrl;

    public User(Integer id, String login, String name, String htmlUrl) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.htmlUrl = htmlUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}';
    }
}
