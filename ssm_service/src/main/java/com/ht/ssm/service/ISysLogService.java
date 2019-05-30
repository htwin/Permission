package com.ht.ssm.service;

import com.ht.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    /**
     * 添加日志
     * @param log
     * @throws Exception
     */
    public void save(SysLog log) throws Exception;

    /**
     * 查询日志列表
     * @return
     * @throws Exception
     */
    public List<SysLog> findAll(Integer page,Integer size) throws Exception;
}
