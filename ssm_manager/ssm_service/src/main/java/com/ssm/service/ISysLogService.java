package com.ssm.service;

import com.ssm.pojo.SysLog;

import java.util.List;

/**
 * @author swy
 * @description: 日志service
 * @date 2020/9/18 17:30
 */
public interface ISysLogService {

    void saveLog(SysLog sysLog);

    List<SysLog> findAll();
}
