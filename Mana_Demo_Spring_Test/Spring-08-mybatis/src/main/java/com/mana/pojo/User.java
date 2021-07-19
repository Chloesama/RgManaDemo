package com.mana.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String name;
    private String sex;
    private int age;
    private Date insertTime;
}
