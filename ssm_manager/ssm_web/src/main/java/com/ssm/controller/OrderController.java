package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Order;
import com.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lenovo
 * @description: 订单controller层
 * @date 2020/9/1 16:02
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
     private IOrderService orderService;

    //未分页
    /*@RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderService.findAll();
        modelAndView.addObject("orderList",orderList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/


    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam int page,@RequestParam int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(orderList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
}
