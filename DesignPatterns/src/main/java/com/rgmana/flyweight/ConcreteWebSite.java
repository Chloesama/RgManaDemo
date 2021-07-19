package com.rgmana.flyweight;

public class ConcreteWebSite extends WebSite {

    private String type = "";


    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void user(User user) {
        System.out.println("网站的发布形式为:" + type + "  在使用中..使用者是:" + user.getName());
    }

}
