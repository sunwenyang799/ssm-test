package com.ssm.dao;

import com.ssm.pojo.Role;
import com.ssm.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author swy
 * @description: 用户dao
 * @date 2020/9/15 9:26
 */
public interface IUserDao {


    @Select("select * from t_users where username = #{username}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roleList", column = "id",javaType = List.class, many = @Many(select = "com.ssm.dao.IRoleDao.getRoleByUserId"))
    })
    UserInfo findByUserName(String username);

    @Select("select * from t_users")
    List<UserInfo> findAll();

    @Insert("insert into t_users(id,email,username,password,phoneNum,status) values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void saveUser(UserInfo user);

    @Select("select * from t_users where id = #{id}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roleList", column = "id",javaType = List.class, many = @Many(select = "com.ssm.dao.IRoleDao.getRoleByUserId"))
    })
    UserInfo findUserById(String id);

    @Insert("insert into t_users_role values(#{userId},#{roleId})")
    void addRole(@Param("userId") String userId,@Param("roleId") String roleId);

}
