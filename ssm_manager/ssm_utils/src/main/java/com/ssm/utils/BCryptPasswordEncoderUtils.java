package com.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * @author swy
 * @description: 加密工具类
 * @date 2020/9/16 17:15
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    /**
     * 加密
     * @param str
     * @return
     */
    public static String encrypt(String str){
        String encodeStr = bCryptPasswordEncoder.encode(str);
        return encodeStr;
    }


    public static void main(String[] args){
//        String encrypt = encrypt("123");
        //        System.out.println(encrypt);
    }
}
