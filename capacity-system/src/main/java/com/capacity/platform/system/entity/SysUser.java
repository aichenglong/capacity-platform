package com.capacity.platform.system.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * Author: Linux
 * Date:2018-06-08
 * Description: 用户表
 * Created by Linux on 2018-06-08.
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String uuid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 盐
     */
    private String salt;
    /**
     * 昵称(或者用户真实姓名)
     */
    private String nickName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别 0 男 1 女
     */
    private Integer gender;
    /**
     * 手机号码
     */
    private String mobile;
    private Boolean accountNonExpired;
    /**
     * 帐户是否锁定
     */
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
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

    /**
     * 主键id
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 主键id
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    /**
     * 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
    /**
     * 昵称(或者用户真实姓名)
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称(或者用户真实姓名)
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 性别 0 男 1 女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别 0 男 1 女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    /**
     * 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    /**
     * 帐户是否锁定
     */
    public Boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * 帐户是否锁定
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    public Boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
        return "SysUser{" +
        ", uuid=" + uuid +
        ", userName=" + userName +
        ", salt=" + salt +
        ", nickName=" + nickName +
        ", age=" + age +
        ", password=" + password +
        ", email=" + email +
        ", gender=" + gender +
        ", mobile=" + mobile +
        ", accountNonExpired=" + accountNonExpired +
        ", accountNonLocked=" + accountNonLocked +
        ", credentialsNonExpired=" + credentialsNonExpired +
        ", enabled=" + enabled +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", modifyUser=" + modifyUser +
        ", modifyDate=" + modifyDate +
        "}";
    }
}
