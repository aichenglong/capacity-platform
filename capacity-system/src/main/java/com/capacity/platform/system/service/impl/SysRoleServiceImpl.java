package com.capacity.platform.system.service.impl;

import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.common.service.impl.AbstractBaseServiceImpl;
import com.capacity.platform.system.entity.SysRole;
import com.capacity.platform.system.mapper.SysRoleMapper;
import com.capacity.platform.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: icl
 * Date:2018/06/03
 * Description:
 * Created by icl on 2018/06/03.
 */
@Service
public class SysRoleServiceImpl extends AbstractBaseServiceImpl<SysRole,String> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public BaseMapper<SysRole, String> getBaseMapper() {
        return null;
    }
}
