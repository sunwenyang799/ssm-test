package com.ssm.controller;

import com.ssm.pojo.SysLog;
import com.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:39 2020/9/18
 * @ Description：日志controller
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> logList = sysLogService.findAll();
        modelAndView.addObject("sysLogs",logList);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
