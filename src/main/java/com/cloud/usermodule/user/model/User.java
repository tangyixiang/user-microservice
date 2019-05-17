package com.cloud.usermodule.user.model;


import com.cloud.usermodule.common.CommonUtils;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String id;
    private String sysUserId;
    private String userName;
    private String password;
    private String email;
    private String createTime;
    private int status;
    private String companyId;
    private String roleId;
    private String permissionId; //自定义的权限规则
    private String region; //用户地区

    public User(){
        this.status = 1; //默认激活状态
        this.createTime = CommonUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public String getId() {
        if(CommonUtils.isEmpty(this.id)){
            this.id = CommonUtils.UUIDUtil();
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }




}
