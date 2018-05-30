package com.capacity.platform.system.entity;

import com.capacity.platform.common.entity.BaseEntity;

/**
 * Author: icl
 * Date:2018/05/26
 * Description:
 * Created by icl on 2018/05/26.
 */
public class SysRole  extends BaseEntity {

    private String name;

    private String roleCode;

    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
