package com.ht.ssm.service;

import com.ht.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    /**
     * 查询角色列表
     * @return
     * @throws Exception
     */
    public List<Role> findAll() throws Exception;

    /**
     * 新建角色
     * @param role
     * @throws Exception
     */
    public void save(Role role)throws Exception;

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    public Role findById(String id)throws Exception;

    /**
     * 查询不属于该用户的其他所有角色
     * @param id
     * @return
     * @throws Exception
     */
    public List<Role> findOtherRole(String id)throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    public void addPermissionToRole(String roleId,String[] permissionId)throws Exception;
}


