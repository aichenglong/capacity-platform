package com.capacity.platform.system.service.impl;

import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.common.service.impl.AbstractBaseServiceImpl;
import com.capacity.platform.system.entity.SysMenu;
import com.capacity.platform.system.mapper.SysMenuMapper;
import com.capacity.platform.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: icl
 * Date:2018/06/03 22:18:24
 * Description:
 * Created by icl on 2018/06/03 22:18:24.
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends AbstractBaseServiceImpl<SysMenu,String> implements
        SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;


    @Override
    public BaseMapper<SysMenu, String> getBaseMapper() {
        return sysMenuMapper;
    }
}
