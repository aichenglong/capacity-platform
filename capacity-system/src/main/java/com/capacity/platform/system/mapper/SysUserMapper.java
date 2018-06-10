package com.capacity.platform.system.mapper;

import com.capacity.platform.system.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 用户表 Mapper 接口
 * Created by Linux on 2018-06-08.
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */

    @Select("findByUserName")
    SysUser findByUserName(String username);
}
