package com.mana.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//等价于 <bean id = "user" class="com.mana.pojo.User">
//@Component 组件
@Component
public class User {
    @Value("Chloe")
    public String name;

}
