package com.rgmana.prototype;


//原型模式
//浅拷贝
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {

        Sheep sheep = new Sheep("tom",1,"白色");
        Sheep s2 = (Sheep) sheep.clone();
        Sheep s3 = (Sheep) sheep.clone();
        Sheep s4 = (Sheep) sheep.clone();
        Sheep s5 = (Sheep) sheep.clone();

        System.out.println(sheep);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}
