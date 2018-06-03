package com.capacity.platform.system.entity;

import com.capacity.platform.common.entity.BaseEntity;

/**
 * Author: icl
 * Date:2018/06/03
 * Description:角色
 * Created by icl on 2018/06/03.
 */
public class SysRole  extends BaseEntity {

    /**
     * 角色主键
     */
  private String uuid;

    /**
     * 角色名称
     */
  private String roleName;

    /**
     * 角色编码
     */
  private String roleCode;

    /**
     * 角色描述
     */
  private String description;

    /**
     * 角色状态
     */
  private int status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}