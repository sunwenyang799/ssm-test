package com.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author swy
 * @description: 权限实体类
 * @date 2020/9/15 9:29
 */
public class Role implements Serializable {

     private String id;
     private String roleName;
     private String roleDesc;
     private List<UserInfo> userInfoLits;
     private List<Permission> permissionList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<UserInfo> getUserInfoLits() {
        return userInfoLits;
    }

    public void setUserInfoLits(List<UserInfo> userInfoLits) {
        this.userInfoLits = userInfoLits;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
