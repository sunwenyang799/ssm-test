package com.ssm.service;

import com.ssm.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author swy
 * @description: 角色service
 * @date 2020/9/17 10:44
 */
public interface IRoleService {

    List<Role> findAll();

    void saveRole(Role role);

    Role findById(String id);

    /**
     *获取用户没有的权限
     * @param userId
     * @return
     */
    List<Role> getOtherRoleByUserId(String userId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
