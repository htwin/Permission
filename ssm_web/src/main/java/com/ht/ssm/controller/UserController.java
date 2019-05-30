package com.ht.ssm.controller;

import com.ht.ssm.domain.Role;
import com.ht.ssm.domain.UserInfo;
import com.ht.ssm.service.IRoleService;
import com.ht.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }


    //用户添加
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id)throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        List<Role> roleList = roleService.findOtherRole(id);
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId,String[] ids)throws Exception{
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }

}
