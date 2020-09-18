package com.ssm.controller;

import com.ssm.pojo.Role;
import com.ssm.pojo.UserInfo;
import com.ssm.service.IRoleService;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author swy
 * @description: 用户controller层
 * @date 2020/9/16 16:14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
     private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(UserInfo user){
        userService.saveUser(user);
        return "redirect:findAll";
    }

    @PreAuthorize("authentication.principal.username=='user'")
    @RequestMapping("/findUserById")
    public ModelAndView findUserById(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userService.findUserById(id);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userService.findUserById(id);
        List<Role> roleList = roleService.getOtherRoleByUserId(id);
        modelAndView.addObject("user",user);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return  modelAndView;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String[] ids){
        userService.addRole(userId,ids);
        return "redirect:findAll";
    }
}
