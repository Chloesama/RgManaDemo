package com.rgmana.prototype.deepclone;

//深拷贝
public class Clinet {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p1 = new DeepProtoType();
        p1.name = "Chloe";
        p1.deepCloneableTarget = new DeepCloneableTarget("RgMana","RgManaType");

        //方式1
        DeepProtoType p2 = (DeepProtoType)p1.clone();
        System.out.println("方式1 ");
        System.out.println(p1.deepCloneableTarget.hashCode());
        System.out.println(p2.deepCloneableTarget.hashCode());

        //方式2
        DeepProtoType p3 = (DeepProtoType)p1.deepClone();
        System.out.println("方式2");
        System.out.println(p1.deepCloneableTarget.hashCode());
        System.out.println(p3.deepCloneableTarget.hashCode());
    }
}
