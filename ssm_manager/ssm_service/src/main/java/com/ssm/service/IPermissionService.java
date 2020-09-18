package com.ssm.service;

import com.ssm.pojo.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author swy
 * @description: 资源权限service
 * @date 2020/9/17 13:23
 */
public interface IPermissionService {

    List<Permission> findAll();

    void savePermission(Permission permission);

    List<Permission> findOtherPermissionByRoleId(String roleId);
}
