package com.capacity.platform.common.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Author: ICL
 * Date:2018/5/19
 * Description:
 * Created by ICL on 2018/5/19.
 */
public class BaseEntity implements java.io.Serializable {


    /**
     * 创建用户
     */

    @ApiModelProperty(hidden = true)
    private String createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createDate;

    /**
     * 修改时间
     */
    @ApiModelProperty(hidden = true)
    private Date modifyDate;

    /**
     * 修改用户
     */
    @ApiModelProperty(hidden = true)
    private Date modifyUser;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Date modifyUser) {
        this.modifyUser = modifyUser;
    }
}
