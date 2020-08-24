package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.service.StatService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName: StatController
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 15:53
 * @Version: 1.0
 **/
@Api(value = "StatController", description = "统计信息控制类")
@CrossOrigin
@RestController
@RequestMapping("/stat")
public class StatController {
    @Resource
    private StatService statService;

    /**
     * @Author guoyangyang
     * @Description  根据县/区统计 农机数量-作业里程-作业面积
     * @Date  2020/7/23 16:05
     * @Param * @param page:
     * @param count:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="县/区统计", notes="县/区统计接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页 - 第几页", required = true ,dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "count", value = "分页 - 一页几条数据", required = true ,dataType = "Integer", paramType = "query")
    })
    @GetMapping("/getAllByCounty")
    @ResponseBody
    public Result getAllByCounty(Integer page, Integer count, Integer checkID, Date workStartTime, Date workEndTime,Integer groupID){
        return statService.getAllByCounty(page, count,checkID,workStartTime,workEndTime,groupID);
    }

    /**
     * @Author guoyangyang
     * @Description  根据农机类型统计 农机数量-作业里程-作业面积
     * @Date  2020/7/23 16:06
     * @Param * @param page:
 * @param count:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="农机类型统计", notes="农机类型统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页 - 第几页", required = true ,dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "count", value = "分页 - 一页几条数据", required = true ,dataType = "Integer", paramType = "query")
    })
    @GetMapping("/getAllByMachineryID")
    @ResponseBody
    public Result getAllByMachineryID(Integer page,Integer count,Integer groupID){
        return statService.getAllByMachineryID(page, count,groupID);
    }

    /**
     * @Author guoyangyang
     * @Description  统计所有/昨天/今天/ 的农机数，与作业面积
     * @Date  2020/7/24 11:22
     * @Param
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="统计所有/昨天/今天/ 的农机数，与作业面积", notes="统计接口")
    @GetMapping("/getStatsWookNum")
    @ResponseBody
    public Result getStatsWookNum(Integer groupID) {
        return ResultUtil.success(statService.getStatsWookNum(groupID));
    }

    /**
     * @Author guoyangyang
     * @Description  统计过去7天的作业面积
     * @Date  2020/7/24 11:24
     * @Param 
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="统计过去7天的作业面积", notes="统计过去7天的作业面积接口")
    @GetMapping("/getPastSeven")
    @ResponseBody
    public Result getPastSeven(Integer groupID) {
        return ResultUtil.success(statService.getPastSeven(groupID));
    }


    /**
     * @Author guoyangyang
     * @Description  统计过去7天的作业面积
     * @Date  2020/7/24 11:24
     * @Param
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="统计过去7天的作业面积", notes="统计过去7天的作业面积接口")
    @GetMapping("/getDecember")
    @ResponseBody
    public Result getDecember(String time,Integer groupID) {
        return statService.getDecember(time,groupID);
    }

    @GetMapping("/getWorkBycounty")
    public Result getWorkBycounty(String county,Integer groupID){
        return statService.getWorkBycounty(county,groupID);
    }

    @GetMapping("/getWorkByNo")
    public Result getWorkByNo(String machineryNO){
        return statService.getWorkByNo(machineryNO);
    }

    @GetMapping("/getWorkByvillage")
    public Result getWorkByvillage(Integer  workID){
        return statService.getWorkByvillage(workID);
    }

    @GetMapping("/getWorkByName")
    public Result getWorkByName(Integer  userID){
        return  statService.getWorkByName(userID);
    }

    @ApiOperation(value="县/区统计", notes="县/区统计接口")
    @GetMapping("/getByCounty")
    @ResponseBody
    public Result getByCounty(Integer groupID){
        return statService.getAllByCounty(groupID);
    }
}
