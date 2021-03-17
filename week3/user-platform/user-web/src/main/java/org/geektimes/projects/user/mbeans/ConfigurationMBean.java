package org.geektimes.projects.user.mbeans;

import org.geektimes.projects.user.domain.User;

/**
 * @author chenpeng.huang
 * @since 2021-03-17
 */
public interface ConfigurationMBean {

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);

    User user();
}
