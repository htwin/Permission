package com.ht.ssm.service;

import com.ht.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {


    /**
     * 根据角色id查询权限列表
     * @param id
     * @return
     * @throws Exception
     */
    public List<Permission> findPermissionByRoleId(String id)throws Exception;

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;

    /**
     * 添加权限
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;

    /**
     * 查询属于该角色之外的权限列表
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermissionByRoleId(String roleId)throws Exception;
}
