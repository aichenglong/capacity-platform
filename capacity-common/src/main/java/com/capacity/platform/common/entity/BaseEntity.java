package com.capacity.platform.common.entity;

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
    private String createUser;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date modfiyeDate;

    /**
     * 修改用户
     */
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

    public Date getModfiyeDate() {
        return modfiyeDate;
    }

    public void setModfiyeDate(Date modfiyeDate) {
        this.modfiyeDate = modfiyeDate;
    }

    public Date getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Date modifyUser) {
        this.modifyUser = modifyUser;
    }
}
