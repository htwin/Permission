package com.ht.ssm.service.impl;

import com.ht.ssm.dao.IUserDao;
import com.ht.ssm.domain.Role;
import com.ht.ssm.domain.UserInfo;
import com.ht.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("进入了userdetails");
        UserInfo userInfo = userDao.findByUsername(username);
        return new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
    }
    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role:roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception {
        List<UserInfo> list = userDao.findAll();
        for(UserInfo user:list){
            user.setStatusStr(user.getStatus()==0?"未启动":"已启动");
        }
        return list;

    }

    @Override
    public void save(UserInfo user) throws Exception {
        String encodePass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePass);
        userDao.save(user);
    }

    @Override
    public UserInfo findById(String id) throws Exception {

        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String [] ids) throws Exception {
        for(String roleId :ids) {
            userDao.addRoleToUser(userId, roleId);
        }
    }

}
