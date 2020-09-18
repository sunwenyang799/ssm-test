package com.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author swy
 * @description: 资源权限
 * @date 2020/9/15 9:31
 */
public class Permission implements Serializable {

    private String id;
    private String permissionName;
    private String url;
    private List<Role> roleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
