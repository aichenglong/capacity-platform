package com.capacity.platform.system.entity;

import java.io.Serializable;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 
 * Created by Linux on 2018-06-08.
 */
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 主键id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
        ", id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
