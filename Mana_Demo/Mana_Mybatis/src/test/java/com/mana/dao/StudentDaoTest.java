package com.mana.dao;

import com.mana.pojo.Student;
import com.mana.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoTest {

    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            //方式一:getMapper
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = mapper.getStudentList2();

            //方式二:selectList
//            List<Student> studentList = sqlSession.selectList("com.mana.dao.StudentMapper.getStudentList");

            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {

        } finally {
            sqlSession.close();
        }
    }

}
