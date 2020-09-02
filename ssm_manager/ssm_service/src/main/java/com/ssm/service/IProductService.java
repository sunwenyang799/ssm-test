package com.ssm.service;

import com.ssm.pojo.Product;

import java.util.List;

/**
 * @author lenovo
 * @description: 商品service层
 * @date 2020/8/31 16:56
 */
public interface IProductService {

    List<Product> findAll(int page,int pageSize);

    void saveProduct(Product product);
}
