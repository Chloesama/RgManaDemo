package com.rgmana.flyweight;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite webSite1 = factory.getWebSiteCategory("新闻");

        webSite1.user(new User("Chloe"));

        WebSite webSite2 = factory.getWebSiteCategory("博客");


        WebSite webSite3 = factory.getWebSiteCategory("博客");

        webSite2.user(new User("RgMana"));
        webSite3.user(new User("RgMana2"));
        webSite2.user(new User("RgMana"));

        System.out.println(webSite1.hashCode() + "," + webSite2.hashCode() + "," + webSite3.hashCode());

        System.out.println(factory.getWebSiteCount());

    }
}
