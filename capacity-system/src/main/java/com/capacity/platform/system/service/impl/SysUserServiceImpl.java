package com.capacity.platform.system.service.impl;

import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.common.service.impl.AbstractBaseServiceImpl;
import com.capacity.platform.system.entity.SysUser;
import com.capacity.platform.system.mapper.SysUserMapper;
import com.capacity.platform.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: ICL
 * Date:2018/5/19
 * Description:
 * Created by ICL on 2018/5/19.
 */
@Service("sysUserService")
public class SysUserServiceImpl extends AbstractBaseServiceImpl<SysUser,String> implements
        
        SysUserService  {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public BaseMapper<SysUser, String> getBaseMapper() {
        return sysUserMapper;
    }
}
