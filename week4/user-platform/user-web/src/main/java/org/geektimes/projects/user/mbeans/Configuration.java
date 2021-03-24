package org.geektimes.projects.user.mbeans;

/**
 * @Author : hxhowl
 * @create 2021/3/15 17:35
 */
public class Configuration implements ConfigurationMBean {

    private String name;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Configuration(String name){
        this.name = name;
        this.value = "1234";
    }

    public Configuration(){
        this.name = "first class";
        this.value = "123";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }

    @Override
    public void printHello() {
        // TODO Auto-generated method stub
        System.out.println(this.name);
    }

}
