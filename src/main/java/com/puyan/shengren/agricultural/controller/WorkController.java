package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.common.ResultUtil;
import com.puyan.shengren.agricultural.enity.Work;
import com.puyan.shengren.agricultural.service.WorkService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.tool.ExprotExcel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: WorkController
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 14:36
 * @Version: 1.0
 **/
@Api(value = "WorkController", description = "作业信息控制类")
@CrossOrigin
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
            @ApiImplicitParam(name = "work", value = "作业信息实体类", required = true ,dataType = "com.puyan.shengren.agricultural.enity.Work"),
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
            @ApiImplicitParam(name = "work", value = "作业信息实体类", required = true ,dataType = "com.puyan.shengren.agricultural.enity.Work"),
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
            @ApiImplicitParam(name = "work", value = "筛选条件", required = false ,dataType = "com.puyan.shengren.agricultural.enity.Work"),
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

    @GetMapping("/uplodExcel")
    @ResponseBody
    public Result uplodExcel(Work work, Integer page, Integer count,HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        Map<String,Object> biaotoulsit=new HashMap<>();
        biaotoulsit.put("序号","1");
        biaotoulsit.put("用户名","userName");
        biaotoulsit.put("所属区域/省","province");
        biaotoulsit.put("所属区域/市","city");
        biaotoulsit.put("所属区域/县","county");
        biaotoulsit.put("所属区域/镇","town");
        biaotoulsit.put("所属区域/村","village");
        biaotoulsit.put("所属区域/合作社","cooperative");
        biaotoulsit.put("车辆编号","machineryNO");
        biaotoulsit.put("农机名称","machineryBrand");
        biaotoulsit.put("车宽","machineryWidth");
        biaotoulsit.put("车主电话","phone");
        biaotoulsit.put("核对面积","confirmArea");
        biaotoulsit.put("作业开始时间","workStartTime");
        biaotoulsit.put("作业结束时间","workEndTime");
        biaotoulsit.put("作业面积","workArea");
        biaotoulsit.put("作业长度","workLength");
        List<Map<String, Object>> maps = workService.upExcel(work, page, count);
        ExprotExcel.exportAll(maps,biaotoulsit,request,response);
        return ResultUtil.success();
    }


}
