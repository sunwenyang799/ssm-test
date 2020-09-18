package com.ssm.service.impl;

import com.ssm.dao.IUserDao;
import com.ssm.pojo.Role;
import com.ssm.pojo.UserInfo;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author swy
 * @description: 用户实现类
 * @date 2020/9/14 17:34
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUserName(username);
        //通过权限登录(不加密)
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthorities(userInfo.getRoleList()));
         //通过权限和是否开启登录(不加密)
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus()==1?true:false,
//                true,true,true,getAuthorities(userInfo.getRoleList()));
        //通过权限和是否开启登录(加密)
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,
                true,true,true,getAuthorities(userInfo.getRoleList()));
        return user;
    }

    //获取用户的角色
    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roleList){
        List<SimpleGrantedAuthority> list =new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roleList) {
            SimpleGrantedAuthority simpleGrantedAuthority =new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            list.add(simpleGrantedAuthority);
        }
        return list;
    }

    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = userDao.findAll();
        return userInfoList;
    }

    public void saveUser(UserInfo user){
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    public UserInfo findUserById(String id) {
        return userDao.findUserById(id);
    }

    public void addRole(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRole(userId,roleId);
        }
    }
}
