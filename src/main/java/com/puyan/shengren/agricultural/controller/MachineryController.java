package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.common.ResultUtil;
import com.puyan.shengren.agricultural.enity.Machinery;
import com.puyan.shengren.agricultural.service.MachineryService;
import com.puyan.shengren.agricultural.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: MachineryController
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 13:53
 * @Version: 1.0
 **/
@Api(value = "/machinery", description = "农业机械操作类")
@CrossOrigin
@RestController
@RequestMapping("/machinery")
public class MachineryController {
    @Resource
    private MachineryService machineryService;

    /**
     * @Author guoyangyang
     * @Description  录入农业机械
     * @Date  2020/7/23 18:42
     * @Param * @param machinery:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="添加农业机械", notes="添加农业机械接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machinery", value = "机械实体类", required = true ,dataType = "com.puyan.shengren.agricultural.enity.Machinery",paramType = "query"),
    })
    @PostMapping("/machineryInsert")
    @ResponseBody
    public Result insert(Machinery machinery){
        return  machineryService.insert(machinery);
    }

    /**
     * @Author guoyangyang
     * @Description  修改农业机械的状态
     * @Date  2020/7/23 18:42
     * @Param * @param machineryID:
     * @param machineryStatus:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="更改农业机械状态", notes="更改农业机械状态接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineryID", value = "农业机械ID", required = true ,dataType = "Integer"),
            @ApiImplicitParam(name = "machineryStatus", value = "农业机械状态", required = true ,dataType = "Integer"),
    })
    @PutMapping("/updateStarus")
    @ResponseBody
    public Result updateStarus(Integer machineryID,Integer machineryStatus){
        return machineryService.updateStarus(machineryID, machineryStatus);
    }

    /**
     * @Author guoyangyang
     * @Description  根据ID修改农业机械的信息
     * @Date  2020/7/23 18:43
     * @Param * @param machinery:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="修改农业机械信息", notes="修改农业机械信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machinery", value = "机械实体类", required = true ,dataType = "com.puyan.shengren.agricultural.enity.Machinery"),
    })
    @PutMapping("/update")
    @ResponseBody
    public Result update(Machinery machinery){
        return machineryService.update(machinery);
    }

    /**
     * @Author guoyangyang
     * @Description  查询所有的农业机械
     * @Date  2020/7/23 18:43
     * @Param * @param map:
     * @param page:
     * @param count:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="获取所有农业机械信息", notes="获取所有农业机械信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Machinery", value = "筛选条件", required = false ,dataType = "com.puyan.shengren.agricultural.enity.Machinery"),
            @ApiImplicitParam(name = "page", value = "分页 - 第几页", required = true ,dataType = "Integer",paramType="query"),
            @ApiImplicitParam(name = "count",value = "分页 - 一页几条数据", required = true ,dataType = "Integer",paramType="query")
    })
    @GetMapping("/getAll")
    @ResponseBody
    public Result getAll(Machinery Machinery, Integer page, Integer count){
        return machineryService.getAll(Machinery, page, count);
    }


    @GetMapping("/getMachineryIsEmpty")
    @ResponseBody
    public Result getMachineryIsEmpty(String machineryNO){
        return machineryService.getMachineryIsEmpty(machineryNO);
    }


    @DeleteMapping("/delete")
    public Result deleteWork(Integer machineryID){
        return ResultUtil.success(machineryService.deleteMachinery(machineryID));
    }
}
