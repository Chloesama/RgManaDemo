package com.mana.mapper;

import com.mana.pojo.User;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface UserMapper {
    List<User> getUser();
}
