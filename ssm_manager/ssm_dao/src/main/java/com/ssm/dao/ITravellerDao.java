package com.ssm.dao;

import com.ssm.pojo.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lenovo
 * @description: 游客dao
 * @date 2020/9/14 14:33
 */
public interface ITravellerDao {

    @Select("select * from t_traveller where id in (select travellerId from t_order_traveller where orderId  = #{orderId})")
    List<Traveller> findById(String orderId);
}
