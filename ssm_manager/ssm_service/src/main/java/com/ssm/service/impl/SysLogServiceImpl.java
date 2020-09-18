package com.ssm.service.impl;

import com.ssm.dao.ISysLogDao;
import com.ssm.pojo.SysLog;
import com.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author swy
 * @description: 日志实现类
 * @date 2020/9/18 17:30
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    public void saveLog(SysLog sysLog) {
            sysLogDao.saveLog(sysLog);
    }

    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
