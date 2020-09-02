package com.ssm.dao;

import com.ssm.pojo.Order;
import com.ssm.pojo.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lenovo
 * @description: 订单dao层
 * @date 2020/9/1 16:01
 */
public interface IOrderDao {

    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.ssm.dao.IProductDao.findById" ))
    })
    @Select("select * from t_orders")
     List<Order> findAll();


}
