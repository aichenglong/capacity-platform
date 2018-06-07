package com.capacity.platform.system.mapper;

import com.capacity.platform.system.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.capacity.platform.system.entity.SysUser;

import java.util.List;

/**
 * Author: Linux
 * Date:2018-06-07
 * Description: 角色表 Mapper 接口
 * Created by Linux on 2018-06-07.
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {


    /**
     * 根据用户id的角色列表
     * @param uuid 用户id
     * @return
     */
    List<SysRole> findByUserId(String uuid);
}
