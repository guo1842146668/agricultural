package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.service.FunctionService;
import com.puyan.shengren.agricultural.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: FunctionController
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 15:40
 * @Version: 1.0
 **/
@Api(value = "FunctionController", description = "方法操作控制类")
@CrossOrigin
@RestController
@RequestMapping("/function")
public class FunctionController {
    @Resource
    private FunctionService functionService;
    
  /*  *//**
     * @Author guoyangyang
     * @Description  根据用户ID获取对应权限
     * @Date  2020/7/22 15:43
     * @Param * @param userID:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **//*
    @ApiOperation(value="根据用户ID获取对应权限", notes="根据用户ID获取对应权限接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true ,dataType = "Integer"),
    })
    @GetMapping("/getFunction")
    @ResponseBody
    public Result getFunctionByUserID(Integer userID){
        return functionService.getFunctionByUserID(userID);
    }*/
    
    /**
     * @Author guoyangyang
     * @Description  获取所有可用权限 将用户角色选择权限
     * @Date  2020/7/22 15:51
     * @Param
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="获取所有权限", notes="获取所有权限接口")
    @GetMapping("/getAll")
    @ResponseBody
    public  Result getAll(){
        return  functionService.getAll();
    }

    /**
     * @Author guoyangyang
     * @Description  为角色增加权限
     * @Date  2020/7/22 17:44
     * @Param * @param functiondata:  暂定为字符串，后续可以适配为数组或者json
     * @param roleID:  角色的ID
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="根据角色添加方法权限", notes="根据角色添加方法权限接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "functiondata", value = "方法的ID集合", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "roleID", value = "角色的ID", required = true ,dataType = "Integer")
    })
    @PostMapping("/allotFunciton")
    @ResponseBody
    public Result allotFunciton(@Param("functiondata") String functiondata, @Param("roleID") Integer roleID){
        return  functionService.allotFunciton(functiondata,roleID);
    }


}
