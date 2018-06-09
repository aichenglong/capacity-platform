package com.capacity.platform.system.service;

import com.capacity.platform.system.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 角色表 服务类
 * Created by Linux on 2018-06-08.
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据菜单查询角色信息
     * @param id
     * @return
     */

    List<SysRole> findByMenuId(String id);
}
