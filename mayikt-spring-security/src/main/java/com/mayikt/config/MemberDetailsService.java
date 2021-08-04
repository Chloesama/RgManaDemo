package com.mayikt.config;

import com.mayikt.entity.PermissionEntity;
import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 余胜军
 * @ClassName MemberDetailsService
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public class MemberDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 1.登录的时候 调用该方法 userName查询账户是否存在 在验证账户的密码
        UserEntity userEntity = userMapper.findByUsername(userName);
        if (userEntity == null) {
            return null;
        }
        // 2.在根据该账户的 userid 关联查询 角色对应权限 动态添加
        List<PermissionEntity> userListpermission = userMapper.findPermissionByUsername(userName);
        // 设置的权限
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        userListpermission.forEach((p -> {
            ///        auth.inMemoryAuthentication().withUser("mayikt_del").password("mayikt_del").authorities("delMember");
            grantedAuthorities.add(new SimpleGrantedAuthority(p.getPermTag()));
        }));
        userEntity.setAuthorities(grantedAuthorities);
        return userEntity;
    }
}
