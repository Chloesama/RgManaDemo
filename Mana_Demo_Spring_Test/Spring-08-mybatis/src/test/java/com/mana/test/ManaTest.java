package com.mana.test;

import com.mana.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManaTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper useMapper = (UserMapper) context.getBean("userMapper2");
        System.out.println(useMapper.getUser());

    }
}
