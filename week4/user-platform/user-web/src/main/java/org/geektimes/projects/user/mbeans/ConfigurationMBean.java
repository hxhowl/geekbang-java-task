package org.geektimes.projects.user.mbeans;

/**
 * @Author : hxhowl
 * @create 2021/3/15 17:35
 */
public interface ConfigurationMBean {
    public String getName();
    public void setName(String name);
    public String getValue();
    public void setValue(String value);
    public void printHello();
}
