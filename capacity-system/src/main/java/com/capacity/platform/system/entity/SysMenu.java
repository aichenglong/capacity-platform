package com.capacity.platform.system.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ICL
 * @since 2018-06-06
 */
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

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
    @TableField("parent_id")
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
    @TableField("order_item")
    private Integer orderItem;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 创建用户
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 修改用户
     */
    @TableField("modify_user")
    private String modifyUser;
    /**
     * 修改时间
     */
    @TableField("modify_date")
    private Date modifyDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Integer orderItem) {
        this.orderItem = orderItem;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
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
