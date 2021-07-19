package com.mana.dao;

import com.mana.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.sql.Struct;
import java.util.List;

public interface StudentMapper {
    List<Student> getStudentList();

    @Select("select * from student")
    List<Student> getStudentList2();
}

