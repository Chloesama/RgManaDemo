package com.chloe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chloe.mapper.user.UserMapper;
import com.chloe.pojo.user.User;
import com.chloe.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hsh
 * @since 2021-07-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
