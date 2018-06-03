package com.capacity.platform.system.mapper;

import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: icl
 * Date:2018/06/03
 * Description: 用户Mapper
 * Created by icl on 2018/06/03.
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser,String> {
}
