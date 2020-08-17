package com.puyan.shengren.agricultural.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.puyan.shengren.agricultural.dao.StatDao;
import com.puyan.shengren.agricultural.service.StatService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StatServiceImpl
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 15:46
 * @Version: 1.0
 **/
@Service
public class StatServiceImpl implements StatService {
    @Resource
    private StatDao statDao;


    @Override
    public Result getAllByCounty(Integer page, Integer count, Integer checkID, Date workStartTime,Date workEndTime) {
        PageHelper.startPage(page,count);
        HashMap hashMap=new HashMap();
        hashMap.put("checkID",checkID);
        hashMap.put("workStartTime",workStartTime);
        hashMap.put("workEndTime",workEndTime);
        List<Map<String, Object>> allByCounty = statDao.getAllByCounty(hashMap);
        if(allByCounty.isEmpty()){
            return ResultUtil.success(null);
        }
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(allByCounty);
        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result getAllByMachineryID(Integer page,Integer count) {
        PageHelper.startPage(page,count);
        List<Map<String, Object>> allByMachineryID = statDao.getAllByMachineryID();
        if(allByMachineryID.isEmpty()){
            return ResultUtil.success(null);
        }
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(allByMachineryID);
        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result getStatsWookNum() {
        return ResultUtil.success(statDao.getStatsWookNum());
    }

    @Override
    public Result getPastSeven() {
        return ResultUtil.success(statDao.getPastSeven());
    }

    @Override
    public Result getDecember(String time) {
        if(StrUtil.hasBlank(time)  || time.equals("")){
            return ResultUtil.success(statDao.getDecember(null));
        }
        return ResultUtil.success(statDao.getDecember(time));
    }

    @Override
    public Result getWorkBycounty(String county) {
        return ResultUtil.success(statDao.getWorkBycounty(county));
    }

    @Override
    public Result getWorkByNo(String machineryNO) {
        return ResultUtil.success(statDao.getWorkByNo(machineryNO));
    }

    @Override
    public Result getWorkByvillage(Integer  workID) {
        return ResultUtil.success(statDao.getWorkByvillage(workID));
    }

    @Override
    public Result getWorkByName(Integer  userID) {
        return ResultUtil.success(statDao.getWorkByName(userID));
    }
}
