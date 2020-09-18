package com.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author swy
 * @description: 用户实体类
 * @date 2020/9/15 9:27
 */
public class UserInfo implements Serializable {

    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private Integer status;//状态0 未开启 1 开启
    private String statusStr;
    private List<Role> roleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status!=null){
            if (status==0){
                statusStr="未开启";
            }else if (status==1){
                statusStr="开启";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
