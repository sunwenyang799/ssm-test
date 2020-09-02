package com.ssm.pojo;

import com.ssm.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lenovo
 * @description: 商品实体类
 * @date 2020/8/31 16:52
 */
public class Product implements Serializable {

    private String id;
    private String productNum;
    private String productName;
    private String cityName;

    //DateTimeFormat解决类型转换问题,也可以使用springmvc全局配置convert
    //传入参数格式必须和pattern格式一致否则也会报错
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date DepartureTime;
    private String departureTimeStr;//页面展示用
    private Integer productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;//页面展示用

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Date departureTime) {
        DepartureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if(DepartureTime!=null){
            departureTimeStr = DateUtil.date2String(DepartureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if(!StringUtils.isEmpty(productStatus)){
            if(productStatus==0){
                productStatusStr ="关闭";
            }else if(productStatus==1){
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
