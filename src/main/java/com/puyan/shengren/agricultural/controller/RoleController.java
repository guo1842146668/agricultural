package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.common.ResultUtil;
import com.puyan.shengren.agricultural.enity.Role;
import com.puyan.shengren.agricultural.service.RoleService;
import com.puyan.shengren.agricultural.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: RoleController
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 9:43
 * @Version: 1.0
 **/
@Api(value = "RoleController", description = "角色操作类")
@CrossOrigin
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * @Author guoyangyang
     * @Description  创建角色
     * @Date  2020/7/22 9:45
     * @Param * @param role:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
     **/
    @ApiOperation(value="添加角色", notes="添加角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色实体类", required = true ,dataType = "com.puyan.shengren.agricultural.enity.Role"),
    })
    @PostMapping("/register")
    @ResponseBody
    public Result register(Role role){
        return  roleService.insert(role);
    }

    /**
     * @Author guoyangyang
     * @Description  修改角色信息或修改角色状态
     * @Date  2020/7/22 10:03
     * @Param * @param role:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
     **/
    @ApiOperation(value="修改角色", notes="修改角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色实体类", required = true ,dataType = "com.puyan.shengren.agricultural.enity.Role"),
    })
    @PutMapping("/update")
    @ResponseBody
    public Result update(Role role) {
        return  roleService.update(role);
    }

    /**
     * @Author guoyangyang
     * @Description  查询所有的角色
     * @Date  2020/7/22 11:03
     * @Param * @param role:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<com.puyan.shengren.agricultural.enity.Role>
     *     返回角色DATA
     **/
    @ApiOperation(value="查询所有角色", notes="查询所有角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "筛选条件", required = true ,dataType = "com.puyan.shengren.agricultural.enity.Role"),
    })
    @GetMapping("/getAll")
    @ResponseBody
    public Result getAll(Role role){
        return  roleService.getAll(role);
    }

    /**
     * @Author guoyangyang
     * @Description  修改角色状态
     * @Date  2020/7/22 15:31
     * @Param * @param roleID:
     * @param status:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="更改角色状态", notes="更改角色状态接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleID", value = "角色ID", required = true ,dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "状态", required = true ,dataType = "Integer")
    })
    @PutMapping("/updateStatus")
    @ResponseBody
    public Result updateStatus(Integer roleID, Integer status){
        return roleService.updateStatus(roleID, status);
    }

    /**
     * @Author guoyangyang
     * @Description  添加用户所需要的的角色
     * @Date  2020/7/22 18:05
     * @Param * @param roleID:  角色的集合
     * @param userID: 用户的ID
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="为用户添加角色", notes="为用户添加角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleID", value = "角色ID集合", required = true ,dataType = "String"),
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true ,dataType = "Integer")
    })
    @PostMapping("/allotRole")
    @ResponseBody
    public Result allotRole(@Param("roleID") String roleID, @Param("roleID") Integer userID){
        return  roleService.allotRole(roleID,userID);
    }


    @ApiOperation(value="根据角色ID查询添加的方法", notes="根据角色ID查询添加的方法接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleID", value = "角色ID", required = true ,dataType = "String")
    })
    @GetMapping("/getRoleByID")
    @ResponseBody
    public Result getRoleAndFuncionByID(@Param("roleID") Integer roleID){
        return ResultUtil.success(roleService.getRoleAndFuncionByID(roleID));
    }

    @DeleteMapping("/delete")
    public Result deleteRole(Integer roleID){
        if(roleID == null){
            return ResultUtil.error(500,"参数错误");
        }
        return  ResultUtil.success(roleService.deleteRole(roleID));
    }

}
