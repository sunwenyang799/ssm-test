package com.ssm.dao;

import com.ssm.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lenovo
 * @description: 商品dao层
 * @date 2020/8/31 16:54
 */
public interface IProductDao {

     @Select("select * from t_product where id  = #{id}")
     Product findById(String id);

     @Select("select * from t_product")
     List<Product> findAll();

     @Insert("insert into t_product(id,productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)" +
             "values(#{id},#{productNum},#{productName},#{cityName},#{DepartureTime},#{productPrice},#{productDesc},#{productStatus})")
     void saveProduct(Product product);
}
