package com.rgmana.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

    List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public College(String name, String des) {
        super(name, des);
    }

    //重写add方法
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    //重写remove


    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    public void print() {
        System.out.println("-------" + getName() + "----------");

        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
