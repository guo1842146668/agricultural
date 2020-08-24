package com.puyan.shengren.agricultural.service;

import com.puyan.shengren.agricultural.common.Result;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StatService
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 15:46
 * @Version: 1.0
 **/
public interface StatService {

    Result getAllByCounty(Integer page, Integer count, Integer checkID, Date workStartTime, Date workEndTime,Integer groupID);

    Result getAllByMachineryID(Integer page,Integer count,Integer groupID);

    Result getStatsWookNum(Integer groupID);

    Result getPastSeven(Integer groupID);

    Result getDecember(String time,Integer groupID);

    Result getWorkBycounty(String  county,Integer groupID);

    Result getWorkByNo(String  machineryNO);

    Result getWorkByvillage(Integer  workID);

    Result getWorkByName(Integer  userID);

    Result getAllByCounty(Integer groupID);
}
