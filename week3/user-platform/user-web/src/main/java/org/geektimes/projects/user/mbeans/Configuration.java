package org.geektimes.projects.user.mbeans;

import org.geektimes.projects.user.domain.User;

/**
 * @author chenpeng.huang
 * @since 2021-03-17
 */
public class Configuration implements ConfigurationMBean {

    private String name;

    private String password;

    public Configuration(){
        this.name = "tester01";
        this.password = "123456";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public User user() {
        User user = new User();
        user.setName("aaa");
        return null;
    }
}
