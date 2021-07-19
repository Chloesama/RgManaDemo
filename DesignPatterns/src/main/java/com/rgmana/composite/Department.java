package com.rgmana.composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
