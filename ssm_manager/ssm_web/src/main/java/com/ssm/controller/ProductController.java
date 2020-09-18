package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Product;
import com.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author lenovo
 * @description: 商品controller层
 * @date 2020/8/31 16:59
 */
@Controller
@RequestMapping("/product")
@RolesAllowed({"ADMIN","USER"})
public class ProductController {

     @Autowired
     private IProductService productService;

     @RequestMapping("/findAll")
     public ModelAndView findAll(@RequestParam Integer page,@RequestParam Integer pageSize){
          ModelAndView modelAndView = new ModelAndView();
          List<Product> productList = productService.findAll(page,pageSize);
          PageInfo pageInfo  = new PageInfo(productList);
          modelAndView.addObject("pageInfo",pageInfo);
          modelAndView.setViewName("product-list-test");
          return modelAndView;
     }

     @RequestMapping("/saveProduct")
     public String saveProduct(Product product){
          productService.saveProduct(product);
          return "redirect:/product/findAll";
     }
}
