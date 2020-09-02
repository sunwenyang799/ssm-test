package com.ssm.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lenovo
 * @description: 类型转换器
 * @date 2020/9/1 14:47
 */
public class String2DateConvert implements Converter<String,Date> {

    public Date convert(String s) {
        Date date = null;
        if(!StringUtils.isEmpty(s)){
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                 date = simpleDateFormat.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }
}
