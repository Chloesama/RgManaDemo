package com.rgmana.builder;

//抽象建造者
public abstract class HouseBuilder {
    protected House house = new House();

    //将建造的流程写好
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    public House buildHouse(){
        return house;

    }
}
