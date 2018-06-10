package com.capacity.platform.security.service;

import com.capacity.platform.security.userdetails.UserInfo;
import com.capacity.platform.system.entity.SysRole;
import com.capacity.platform.system.entity.SysRoleMenu;
import com.capacity.platform.system.entity.SysUser;
import com.capacity.platform.system.entity.SysUserRole;
import com.capacity.platform.system.mapper.SysRoleMapper;
import com.capacity.platform.system.mapper.SysUserMapper;
import com.capacity.platform.system.mapper.SysUserRoleMapper;
import com.capacity.platform.util.StringUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: icl
 * Date:2018/06/02
 * Description: 自定义CustomS
 * Created by icl on 2018/06/02.
 */
@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Autowired
    private SysRoleMapper sysRoleMapper;



    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        if(StringUtils.isEmpty(username)){

            throw new UsernameNotFoundException("用户名不能为空!");
        }

        SysUser user = sysUserMapper.findByUserName(username);

        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }


        // 获取当前用户的权限集合
        List<GrantedAuthority> authorities = getAuthorities(user.getUuid());

        return new UserInfo(user.getUuid().toString(),
                user.getUserName(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                authorities);
    }

    private List<GrantedAuthority> getAuthorities(String uuid) {

        List<GrantedAuthority> list = Lists.newLinkedList();
        List<SysRole> roles = sysRoleMapper.findByUserId(uuid);
        roles.stream().forEach(r -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.getRoleCode());
            list.add(authority);
        });
        return list;
    }
}
