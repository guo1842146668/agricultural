package com.puyan.shengren.agricultural.service.impl;

import cn.hutool.core.util.StrUtil;
import com.puyan.shengren.agricultural.dao.RoleDao;
import com.puyan.shengren.agricultural.enity.Role;
import com.puyan.shengren.agricultural.service.RoleService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleServiceImpl
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 9:33
 * @Version: 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * @Author guoyangyang
     * @Description  创建角色
     * @Date  2020/7/22 9:41
     * @Param * @param role:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
     *     返回成功失败code
     **/
    @Override
    public Result insert(Role role) {
        if(StrUtil.hasBlank(role.getRoleName())){
            return ResultUtil.error(500,"角色名称不能为空");
        }
        //第一次创建状态为正常
        role.setStatus(1);
        int resCount = roleDao.insert(role);
        if(resCount==0){
            return  ResultUtil.error(400,"创建失败");
        }
        return ResultUtil.success();
    }

    /**
     * @Author guoyangyang
     * @Description  更新Role表方法
     * @Date  2020/7/22 10:01
     * @Param * @param role:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
     *     返回成功失败code
     **/
    @Override
    public Result update(Role role) {
        if(role == null){
            return ResultUtil.error(500,"参数错误");
        }
        if(StrUtil.hasBlank(role.getRoleName())){
            return ResultUtil.error(500,"角色名称不能为空");
        }
        int resCount = roleDao.update(role);
        if(resCount==0){
            return  ResultUtil.error(400,"更新失败");
        }
        return ResultUtil.success();
    }

    /**
     * @Author guoyangyang
     * @Description  查询所有角色
     * @Date  2020/7/22 10:40
     * @Param * @param role:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<com.puyan.shengren.agricultural.Enity.Role>
     *     返回封装的角色 data
     **/
    @Override
    public Result getAll(Role role) {
        return ResultUtil.success(roleDao.getAll(role));
    }

    /**
     * @Author guoyangyang
     * @Description  修改角色状态
     * @Date  2020/7/22 15:26
     * @Param * @param roleID:
     * @param status:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @Override
    public Result updateStatus(Integer roleID, Integer status) {
        int resCount=roleDao.updateStatus(roleID,status);
        if(resCount == 0){
            return  ResultUtil.error(400,"更新失败");
        }
        return  ResultUtil.success();
    }

    /**
     * @Author guoyangyang
     * @Description  条件用户对应的角色
     * @Date  2020/7/22 18:03
     * @Param * @param roleID:
     * @param userID: 用户ID
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @Override
    public Result allotRole(String roleID, Integer userID) {
        if(roleID.length()>0){
            String[] array=roleID.split(",");
            for (int i = 0; i < array.length; i++) {
                if (roleDao.getRoleByUserID(userID,Integer.parseInt(array[i]))<1){
                    roleDao.insertRoleUser(userID,Integer.parseInt(array[i]));
                }
            }
            return ResultUtil.success();
        }
        return ResultUtil.error(500,"functiondata不可为空");
    }

    @Override
    public List<Map<String, Object>> getRoleAndFuncionByID(Integer roleID) {
        return roleDao.getRoleAndFuncionByID(roleID);
    }

    @Override
    public int deleteRole(Integer roleID) {
        roleDao.deleteRole(roleID);
        roleDao.deleteUser_role(roleID);
        roleDao.deleteRole_function(roleID);
        return 1;
    }


}
