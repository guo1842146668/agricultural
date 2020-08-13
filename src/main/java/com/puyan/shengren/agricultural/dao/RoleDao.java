package com.puyan.shengren.agricultural.dao;

import com.puyan.shengren.agricultural.enity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @ClassName: RoleDao
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 9:21
 * @Version: 1.0
 **/
@Mapper
public interface RoleDao {

    int insert(Role role);

    int update(Role role);

    List<Role> getAll(Role role);

    int updateStatus(@Param("roleID") Integer roleID,@Param("status") Integer status);

    int getRoleByUserID(Integer userID,Integer roleID);

    int insertRoleUser(Integer userID,Integer roleID);

    List<Map<String,Object>> getRoleAndFuncionByID(Integer roleID);

    int deleteRole(Integer roleID);

    int deleteUser_role(Integer roleID);

    int deleteRole_function(Integer roleID);
}
