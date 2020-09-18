package com.ssm.service.impl;

import com.ssm.dao.IPermissionDao;
import com.ssm.pojo.Permission;
import com.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author swy
 * @description: 资源权限实现类
 * @date 2020/9/17 13:24
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    public void savePermission(Permission permission) {
        permission.setId(UUID.randomUUID().toString().replace("-", ""));
        permissionDao.savePermission(permission);
    }

    public List<Permission> findOtherPermissionByRoleId(String roleId) {
        return permissionDao.findOtherPermissionByRoleId(roleId);
    }
}
