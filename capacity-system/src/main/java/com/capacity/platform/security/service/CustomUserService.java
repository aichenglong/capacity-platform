package com.capacity.platform.security.service;

import com.capacity.platform.system.entity.SysRole;
import com.capacity.platform.system.entity.SysRoleMenu;
import com.capacity.platform.system.entity.SysUser;
import com.capacity.platform.system.entity.SysUserRole;
import com.capacity.platform.system.mapper.SysRoleMapper;
import com.capacity.platform.system.mapper.SysUserMapper;
import com.capacity.platform.system.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: icl
 * Date:2018/06/02
 * Description: 自定义CustomS
 * Created by icl on 2018/06/02.
 */
@Service
public class CustomUserService   implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        SysUser user = sysUserMapper.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SysRole>  sysRoles=  sysRoleMapper.findByUserId(user.getUuid());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role:sysRoles)
        {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            System.out.println(role.getRoleName());
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), authorities);
    }
}
