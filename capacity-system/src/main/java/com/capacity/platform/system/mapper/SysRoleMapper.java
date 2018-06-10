package com.capacity.platform.system.mapper;

import com.capacity.platform.system.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 角色表 Mapper 接口
 * Created by Linux on 2018-06-08.
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 根据用户id查询角色信息
     * @param uuid
     * @return
     */

    List<SysRole> findByUserId(String uuid);

    /**
     * 根据菜单id查询对应的角色列表
     * @param id
     * @return
     */
    List<SysRole> selectMenuId(@Param("id") String id);


}
