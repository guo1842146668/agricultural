package com.puyan.shengren.agricultural.dao;

import com.puyan.shengren.agricultural.common.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StatDao 统计查询
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 15:03
 * @Version: 1.0
 **/
@Mapper
public interface StatDao {
    List<Map<String,Object>> getAllByCounty(HashMap map);

    List<Map<String,Object>> getAllByMachineryID(Integer groupID);

    List<Map<String,Object>> getStatsWookNum(Integer groupID);

    List<Map<String,Object>> getPastSeven(Integer groupID);

    List<Map<String,Object>> getDecember(String time,Integer groupID);

    List<Map<String,Object>> getWorkBycounty(String  county,Integer groupID);

    List<Map<String,Object>> getWorkByNo(String  machineryNO);

    List<Map<String,Object>> getWorkByvillage(Integer  workID);

    List<Map<String,Object>> getWorkByName(Integer  userID);

    List<Map<String,Object>> getByCounty(Integer groupID);
}
