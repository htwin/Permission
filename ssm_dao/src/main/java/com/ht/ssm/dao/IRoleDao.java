package com.ht.ssm.dao;

import com.ht.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    public List<Role> findAll()throws Exception;


    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role)throws Exception;

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(column = "id",property = "permissions",javaType = List.class,many =
            @Many(select = "com.ht.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public Role findById(String id)throws Exception;

    @Select("select * from role where id not in(select roleId from users_role where userId=#{id})")
    public List<Role> findOtherRole(String id);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId)throws Exception;
}
