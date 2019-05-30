package com.ht.ssm.service;

import com.ht.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAll()throws Exception;

    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    public void save(UserInfo user)throws Exception;

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findById(String id)throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    public void addRoleToUser(String userId,String[] ids)throws Exception;

}
