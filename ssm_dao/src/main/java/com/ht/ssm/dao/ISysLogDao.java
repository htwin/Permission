package com.ht.ssm.dao;

import com.ht.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {
    @Select("select * from syslog")
    public List<SysLog> findAll()throws Exception;


    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method)" +
            " values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog log)throws Exception;
}
