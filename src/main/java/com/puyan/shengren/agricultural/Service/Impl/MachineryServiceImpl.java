package com.puyan.shengren.agricultural.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.puyan.shengren.agricultural.Dao.MachineryDao;
import com.puyan.shengren.agricultural.Enity.Machinery;
import com.puyan.shengren.agricultural.Service.MachineryService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: MachineryServiceImpl
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 13:39
 * @Version: 1.0
 **/
@Service
public class MachineryServiceImpl implements MachineryService {
    @Resource
    private MachineryDao machineryDao;

    @Override
    public Result insert(Machinery machinery) {
        if(machinery == null){
            return ResultUtil.error(500,"参数错误");
        }
        if(machinery.getMachineryNO() == null){
            return ResultUtil.error(500,"农业机械编号为空");
        }
        machinery.setMachineryStatus(1);
        int resCount = machineryDao.insert(machinery);
        if(resCount == 0){
            return ResultUtil.error(400,"录入失败");
        }
        return ResultUtil.success();
    }

    @Override
    public Result updateStarus(Integer machineryID, Integer machineryStatus) {
        if (machineryID == null){
            return ResultUtil.error(500,"机械ID不能为空");
        }
        if (machineryStatus == null){
            return ResultUtil.error(500,"机械状态不能为空");
        }
        int resCount = machineryDao.updateStarus(machineryID, machineryStatus);
        if(resCount == 0){
            return  ResultUtil.error(400,"更新失败");
        }
        return ResultUtil.success();
    }

    @Override
    public Result update(Machinery machinery) {
        int resCount = machineryDao.update(machinery);
        if(resCount == 0){
            return ResultUtil.error(400,"更新失败");
        }
        return ResultUtil.success();
    }

    @Override
    public Result getAll(Machinery Machinery, Integer page, Integer count) {
        PageHelper.startPage(page,count);
        List<Machinery> machineryList = machineryDao.getAll(Machinery);
        if(machineryList == null){
            return  ResultUtil.success(null);
        }
        PageInfo<Machinery> pageInfo=new PageInfo<>(machineryList);
        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result getMachineryIsEmpty(String machineryNO) {
        Machinery machineryIsEmpty = machineryDao.getMachineryIsEmpty(machineryNO);
        if(machineryIsEmpty == null){
            return ResultUtil.success(null);
        }
        return ResultUtil.success(machineryIsEmpty);
    }
}
