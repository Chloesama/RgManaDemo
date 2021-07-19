package com.rgmana.builder;

public class Clinet {

    public static void main(String[] args) {
        //盖普通房子
        new HouseDirector(new CommonHouse()).constructHoust();

        //盖高楼
        new HouseDirector(new HighBuilding()).constructHoust();
    }
}
