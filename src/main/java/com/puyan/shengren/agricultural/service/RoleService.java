package com.puyan.shengren.agricultural.service;
import com.puyan.shengren.agricultural.enity.Role;
import com.puyan.shengren.agricultural.common.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleService
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 9:33
 * @Version: 1.0
 **/
public interface RoleService {

    Result insert(Role role);

    Result update(Role role);

    Result getAll(Role role);

    Result updateStatus(@Param("roleID") Integer roleID, @Param("status") Integer status);

    Result allotRole(@Param("roleID") Integer roleID, @Param("roleID") Integer userID);

    List<Map<String,Object>> getRoleAndFuncionByID(Integer roleID);

    int deleteRole(Integer roleID);
}
