package com.capacity.platform.system.service.impl;

import com.capacity.platform.system.entity.SysRole;
import com.capacity.platform.system.mapper.SysRoleMapper;
import com.capacity.platform.system.service.SysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 角色表 服务实现类
 * Created by Linux on 2018-06-08.
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findByMenuId(String id) {
        return sysRoleMapper.findByMenuId(id);
    }
}
