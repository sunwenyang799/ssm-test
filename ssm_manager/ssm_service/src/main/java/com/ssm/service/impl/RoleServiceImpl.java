package com.ssm.service.impl;

import com.ssm.dao.IRoleDao;
import com.ssm.pojo.Role;
import com.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author swy
 * @description: 角色实现类
 * @date 2020/9/17 10:44
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void saveRole(Role role) {
        role.setId(UUID.randomUUID().toString().replace("-",""));
        roleDao.saveRole(role);
    }

    public Role findById(String id) {
        return roleDao.findById(id);
    }

    public List<Role> getOtherRoleByUserId(String userId) {
        return roleDao.getOtherRoleByUserId(userId);
    }

    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
