package com.ssm.dao;

import com.ssm.pojo.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author swy
 * @description: 资源权限dao
 * @date 2020/9/17 10:06
 */
public interface IPermissionDao {

    @Select("select * from t_permission where id in (select permissionId from t_role_permission where roleId = #{roleId})")
     List<Permission>  findByRoleId(String roleId);

    @Select("select * from t_permission")
    List<Permission> findAll();

    @Insert("insert into t_permission values(#{id},#{permissionName},#{url})")
    void savePermission(Permission permission);

    /**
     * 获取角色没有的资源权限
     * @param roleId
     * @return
     */
    @Select("select * from t_permission where id not in (select permissionId from t_role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissionByRoleId(String roleId);
}
