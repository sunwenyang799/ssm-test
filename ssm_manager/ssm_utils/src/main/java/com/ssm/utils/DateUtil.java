package com.ssm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lenovo
 * @description: 日期转换工具类
 * @date 2020/9/1 9:56
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
     private DateUtil(){}

    /**
     * 日期转换字符串
     * @param date
     * @param pattern
     * @return
     */
     public static String date2String(Date date ,String pattern){
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
         String format = simpleDateFormat.format(date);
         return format;
     }

    /**
     * 字符串转换日期
     * @param str
     * @param pattern
     * @return
     */
     public static Date string2Date(String str,String pattern){
         SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern);
         Date date  = null;
         try {
              date = simpleDateFormat.parse(str);
         } catch (ParseException e) {
             logger.error("日期转换错误"+e);
         }
            return date;
     }
}
