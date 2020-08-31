package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ResultUtil;
import com.puyan.shengren.agricultural.service.GroupService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author idmin
 */
@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController {
    @Resource
    private GroupService groupService;

    @ApiOperation(value="添加分组", notes="添加分组接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupName", value = "分组名称", required = true ,dataType = "String"),
    })
    @PostMapping("/saveGroup")
    public Result saveGroup(String groupName){
        return ResultUtil.success(groupService.saveGroup(groupName));
    }

    @ApiOperation(value="查询所有分组", notes="查询所有分组接口")
    @GetMapping("listGroup")
    public Result listGroup(Integer UserID){
        return  ResultUtil.success(groupService.listGroup(UserID));
    }
}
