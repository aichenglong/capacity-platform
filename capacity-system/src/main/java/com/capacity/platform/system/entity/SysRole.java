package com.capacity.platform.system.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * Author: Linux
 * Date:2018-06-07
 * Description: 角色表
 * Created by Linux on 2018-06-07.
 */
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色表名
     */
    private String roleCode;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 状态 0 可用 1 不可用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建用户
     */
    private String createUser;
    /**
     * 修改用户
     */
    private String modifyUser;
    /**
     * 修改时间
     */
    private Date modifyDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /**
     * 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    /**
     * 角色表名
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 角色表名
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    /**
     * 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 角色描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * 状态 0 可用 1 不可用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0 可用 1 不可用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
     * 创建用户
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    /**
     * 修改用户
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 修改用户
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
    /**
     * 修改时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 修改时间
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "SysRole{" +
        ", id=" + id +
        ", roleName=" + roleName +
        ", roleCode=" + roleCode +
        ", description=" + description +
        ", status=" + status +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", modifyUser=" + modifyUser +
        ", modifyDate=" + modifyDate +
        "}";
    }
}
