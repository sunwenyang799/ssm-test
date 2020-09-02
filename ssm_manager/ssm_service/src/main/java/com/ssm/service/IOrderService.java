package com.ssm.service;

import com.ssm.pojo.Order;

import java.util.List;

/**
 * @author lenovo
 * @description: 订单service层
 * @date 2020/9/1 16:02
 */
public interface IOrderService {

    List<Order> findAll(int page,int pageSize);
}
