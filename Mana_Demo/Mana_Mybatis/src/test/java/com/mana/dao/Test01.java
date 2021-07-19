package com.mana.dao;

import com.mana.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        Student student = new Student();

        student.setId(1);
        student.setName("Chloe");
        student.setAge(20);

        System.out.println("student = " + student);

    }
}
