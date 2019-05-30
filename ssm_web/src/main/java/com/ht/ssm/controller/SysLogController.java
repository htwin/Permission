package com.ht.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.ssm.domain.SysLog;
import com.ht.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/sysLog")
@Controller
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) throws Exception {
        //分页
        PageHelper.startPage(page,size);
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll(page,size);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);
        mv.addObject("sysLogs", sysLogs);
        mv.addObject("currentPage",pageInfo.getPageNum());//当前页
        mv.addObject("pages",pageInfo.getPages());//页数
        mv.addObject("total",pageInfo.getTotal());//总记录数
        mv.setViewName("syslog-list");

        return mv;
    }
}
