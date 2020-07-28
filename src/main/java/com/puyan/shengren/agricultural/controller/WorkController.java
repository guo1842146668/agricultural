package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.enity.Work;
import com.puyan.shengren.agricultural.service.WorkService;
import com.puyan.shengren.agricultural.common.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @ClassName: WorkController
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 14:36
 * @Version: 1.0
 **/
@Api(value = "WorkController", description = "作业信息控制类")
@RestController
@RequestMapping("/work")
public class WorkController {
    @Resource
    private WorkService workService;

    /**
     * @Author guoyangyang
     * @Description  作业信息表插入
     * @Date  2020/7/24 8:54
     * @Param * @param work:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="录入作业信息", notes="录入作业信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "work", value = "作业信息实体类", required = true ,dataType = "com.puyan.shengren.agricultural.Enity.Work"),
    })
    @PostMapping("/work_insert")
    @ResponseBody
    public Result insert(@RequestBody Work work){
        return  workService.insert(work);
    }

    /**
     * @Author guoyangyang
     * @Description  作业信息表根据ID删除
     * @Date  2020/7/24 8:54
     * @Param * @param workID:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="根据ID删除作业信息", notes="根据ID删除作业信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workID", value = "作业信息ID", required = true ,dataType = "Integer"),
    })
    @DeleteMapping("/delete")
    @ResponseBody
    public Result delete(Integer workID){
         return workService.delete(workID);
    }

    /**
     * @Author guoyangyang
     * @Description  作业信息表根据ID修改信息
     * @Date  2020/7/24 8:54
     * @Param * @param work:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="修改作业信息", notes="修改作业信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "work", value = "作业信息实体类", required = true ,dataType = "com.puyan.shengren.agricultural.Enity.Work"),
    })
    @PutMapping("/update")
    @ResponseBody
    public Result update(Work work){
        return  workService.update(work);
    }

    /**
     * @Author guoyangyang
     * @Description  获取作业信息表所有的数据
     * @Date  2020/7/24 8:57
     * @Param * @param map:
     * @param page:
     * @param count:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="查询所有作业信息", notes="查询所有作业信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "work", value = "筛选条件", required = false ,dataType = "com.puyan.shengren.agricultural.Enity.Work"),
            @ApiImplicitParam(name = "page", value = "分页 - 第几页", required = true ,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "count", value = "分页 - 一页几条数据", required = true ,dataType = "Integer",paramType = "query")
    })
    @GetMapping("/getAll")
    @ResponseBody
    public Result getAll(Work work, Integer page, Integer count){
        return  workService.getAll(work, page, count);
    }


    @ApiOperation(value = "上传图片文件,支持多图片上传")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true,dataType = "MultipartFile",allowMultiple = true),
            @ApiImplicitParam(name = "workID", value = "需要归属于那一条记录的ID", required = true, dataType = "Integer", paramType = "query")
    })
    @PostMapping(value="/uploadImgs")
    @ResponseBody
    public Result uploadImgs( @RequestParam(value="file") MultipartFile[] files,Integer workID){
      return  workService.uploadImgs(files, workID);
    }



}
