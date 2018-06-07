package com.capacity.platform.system.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * Author: Linux
 * Date:2018-06-07
 * Description: 
 * Created by Linux on 2018-06-07.
 */
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单地址
     */
    private String href;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 父菜单Id
     */
    private String parentId;
    /**
     * 菜单类型 0 一级菜单 1 二级菜单 2 按钮
     */
    private Integer type;
    /**
     * 引用类型
     */
    private String target;
    /**
     * 状态 0 启用 1 不启用
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer orderItem;
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
     * 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 菜单地址
     */
    public String getHref() {
        return href;
    }

    /**
     * 菜单地址
     */
    public void setHref(String href) {
        this.href = href;
    }
    /**
     * 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
    /**
     * 父菜单Id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 父菜单Id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    /**
     * 菜单类型 0 一级菜单 1 二级菜单 2 按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 菜单类型 0 一级菜单 1 二级菜单 2 按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }
    /**
     * 引用类型
     */
    public String getTarget() {
        return target;
    }

    /**
     * 引用类型
     */
    public void setTarget(String target) {
        this.target = target;
    }
    /**
     * 状态 0 启用 1 不启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0 启用 1 不启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * 排序
     */
    public Integer getOrderItem() {
        return orderItem;
    }

    /**
     * 排序
     */
    public void setOrderItem(Integer orderItem) {
        this.orderItem = orderItem;
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
        return "SysMenu{" +
        ", id=" + id +
        ", name=" + name +
        ", href=" + href +
        ", icon=" + icon +
        ", parentId=" + parentId +
        ", type=" + type +
        ", target=" + target +
        ", status=" + status +
        ", orderItem=" + orderItem +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", modifyUser=" + modifyUser +
        ", modifyDate=" + modifyDate +
        "}";
    }
}
