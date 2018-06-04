package com.capacity.platform.system.entity;

import com.capacity.platform.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Author icl
 * Date: 2018/06/03 22:18:24
 * Description:sys_menu 
 * Created by icl on 2018/06/03 22:18:24
 */
public class SysMenu extends BaseEntity implements Serializable {


    @ApiModelProperty("主键")
    private String id;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;

    /**
     * 菜单地址
     */
    @ApiModelProperty("菜单地址")
    private String href;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String icon;

    /**
     * 父菜单Id
     */
    @ApiModelProperty("父菜单ID")
    private String parentId;

    /**
     * 菜单类型 0 一级菜单 1 二级菜单 2 按钮
     */
    @ApiModelProperty("菜单类型 0 一级菜单 1 二级菜单 2 按钮")
    private Integer type;

    /**
     * 引用类型
     */
    @ApiModelProperty("href 引用类型")
    private String target;

    /**
     * 状态 0 启用 1 不启用
     */
    @ApiModelProperty("状态0 启用 1 不启用")
    private Integer status;


    private static final long serialVersionUID = 1L;

    /**
     * sys_menu 
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.id
     */
    public String getId() {
        return id;
    }

    /**
     * sys_menu 
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param id the value for sys_menu.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * sys_menu 菜单名称
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.name
     */
    public String getName() {
        return name;
    }

    /**
     * sys_menu 菜单名称
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param name the value for sys_menu.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sys_menu 菜单地址
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.href
     */
    public String getHref() {
        return href;
    }

    /**
     * sys_menu 菜单地址
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param href the value for sys_menu.href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * sys_menu 菜单图标
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * sys_menu 菜单图标
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param icon the value for sys_menu.icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * sys_menu 父菜单Id
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * sys_menu 父菜单Id
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param parentId the value for sys_menu.parent_id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * sys_menu 菜单类型 0 一级菜单 1 二级菜单 2 按钮
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.type
     */
    public Integer getType() {
        return type;
    }

    /**
     * sys_menu 菜单类型 0 一级菜单 1 二级菜单 2 按钮
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param type the value for sys_menu.type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * sys_menu 引用类型
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.target
     */
    public String getTarget() {
        return target;
    }

    /**
     * sys_menu 引用类型
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param target the value for sys_menu.target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * sys_menu 状态 0 启用 1 不启用
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     * @return the value of sys_menu.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * sys_menu 状态 0 启用 1 不启用
     * author: icl
     * Created by icl on 2018/06/03 22:18:24
     *
     * @param status the value for sys_menu.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }


}