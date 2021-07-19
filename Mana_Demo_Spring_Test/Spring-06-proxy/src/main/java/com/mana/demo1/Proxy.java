package com.mana.demo1;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        this.seeHousr();
        host.rent();
        this.hetong();
        this.fare();
    }

    public void seeHousr(){
        System.out.println("中介带你看房");
    }

    public void fare(){
        System.out.println("收中介费!");
    }

    public void hetong(){
        System.out.println("签租聘合同");
    }
}
