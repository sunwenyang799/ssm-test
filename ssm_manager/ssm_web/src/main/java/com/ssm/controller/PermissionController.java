package com.ssm.controller;

import com.ssm.pojo.Permission;
import com.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author swy
 * @description: 资源权限controller
 * @date 2020/9/17 13:21
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
     private IPermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/savePermission")
    public String savePermission(Permission permission){
        permissionService.savePermission(permission);
        return "redirect:findAll";
    }
}
