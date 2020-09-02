package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.IOrderDao;
import com.ssm.pojo.Order;
import com.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 * @description: 订单实现类
 * @date 2020/9/1 16:02
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    public List<Order> findAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return orderDao.findAll();
    }
}
