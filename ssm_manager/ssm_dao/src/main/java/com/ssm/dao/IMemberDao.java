package com.ssm.dao;

import com.ssm.pojo.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author lenovo
 * @description: 会员dao
 * @date 2020/9/14 14:01
 */
public interface IMemberDao {

    @Select("select * from t_member where id = #{id}")
     Member findById(String id);
}
