package com.ssm.dao;

import com.ssm.pojo.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author swy
 * @description: 日志dao
 * @date 2020/9/18 17:28
 */
public interface ISysLogDao {

    @Insert("insert into t_syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void saveLog(SysLog sysLog);

    @Select("select * from t_syslog")
    List<SysLog> findAll();
}
