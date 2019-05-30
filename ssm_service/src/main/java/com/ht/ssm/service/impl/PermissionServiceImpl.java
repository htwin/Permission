package com.ht.ssm.service.impl;

import com.ht.ssm.dao.IPermissionDao;
import com.ht.ssm.domain.Permission;
import com.ht.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;


    @Override
    public List<Permission> findPermissionByRoleId(String id) throws Exception {
        return permissionDao.findPermissionByRoleId(id);
    }

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermissionByRoleId(String roleId) throws Exception {
        return permissionDao.findOtherPermissionByRoleId(roleId);
    }
}
