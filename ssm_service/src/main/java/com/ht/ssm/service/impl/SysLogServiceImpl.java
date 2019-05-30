package com.ht.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ht.ssm.dao.ISysLogDao;
import com.ht.ssm.domain.SysLog;
import com.ht.ssm.service.ISysLogService;
import com.ht.ssm.utils.DateUtils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer size) throws Exception {

        //将日期转成字符串格式显示
        List<SysLog> list = sysLogDao.findAll();
        for(SysLog log:list){
            String str = DateUtils.date2String(log.getVisitTime(), "yyyy-MM-dd");
            log.setVisitTimeStr(str);
        }
        return list;
    }
}
