package com.capacity.platform.system.service.impl;

import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.common.service.impl.AbstractBaseServiceImpl;
import com.capacity.platform.system.entity.SysUser;
import com.capacity.platform.system.service.SysUserSesrvice;
import org.springframework.stereotype.Service;

/**
 * Author: icl
 * Date:2018/06/03
 * Description:
 * Created by icl on 2018/06/03.
 */
@Service("sysUserService")
public class SysUserServiceImpl extends AbstractBaseServiceImpl<SysUser,String> implements SysUserSesrvice {

    @Override
    public BaseMapper<SysUser, String> getBaseMapper() {
        return null;
    }
}
