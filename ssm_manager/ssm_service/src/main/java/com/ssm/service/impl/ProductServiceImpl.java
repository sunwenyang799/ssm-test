package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.IProductDao;
import com.ssm.pojo.Product;
import com.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author lenovo
 * @description: IProductService实现类
 * @date 2020/8/31 16:56
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> findAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return productDao.findAll();
    }

    public void saveProduct(Product product) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        product.setId(uuid);
        productDao.saveProduct(product);
    }
}
