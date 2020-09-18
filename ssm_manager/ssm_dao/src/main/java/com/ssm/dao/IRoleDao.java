package com.ssm.dao;

import com.ssm.pojo.Role;
import com.ssm.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author swy
 * @description: 角色dao
 * @date 2020/9/16 14:29
 */
public interface IRoleDao {


    @Select("select * from t_role where id  in (select RoleId from t_users_role where userId = #{userId})")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissionList",javaType = List.class,
            many = @Many(select = "com.ssm.dao.IPermissionDao.findByRoleId"))
    })
    List<Role> getRoleByUserId(String userId);

    @Select("select * from t_role")
    List<Role> findAll();

    @Insert("insert into t_role values(#{id},#{roleName},#{roleDesc})")
    void saveRole(Role role);

    @Select("select * from t_role where id = #{id}")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissionList",javaType = List.class,
                    many = @Many(select = "com.ssm.dao.IPermissionDao.findByRoleId"))
    })
    Role findById(String id);

    /**
     *获取用户没有的权限
     * @param userId
     * @return
     */
    @Select("select * from t_role where id  not in (select RoleId from t_users_role where userId = #{userId})")
    List<Role> getOtherRoleByUserId(String userId);

    @Insert("insert into t_role_permission values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId")String roleId,@Param("permissionId")String permissionId);

}
