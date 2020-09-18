package com.ssm.service;

import com.ssm.pojo.Role;
import com.ssm.pojo.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author swy
 * @description: 用户service
 * @date 2020/9/14 17:33
 */
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll();

    void saveUser(UserInfo user);

    UserInfo findUserById(String id);

    void addRole(String userId,String[] roleIds);

}
