package com.capacity.platform.system.entity;

import java.io.Serializable;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 角色菜单表	
 * Created by Linux on 2018-06-08.
 */
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 菜单id
     */
    private String menuId;

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
    /**
     * 菜单id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 菜单id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "SysRoleMenu{" +
        ", id=" + id +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}";
    }
}
