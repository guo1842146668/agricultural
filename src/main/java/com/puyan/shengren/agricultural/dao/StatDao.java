package com.puyan.shengren.agricultural.dao;

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

    List<Map<String,Object>> getAllByMachineryID();

    List<Map<String,Object>> getStatsWookNum();

    List<Map<String,Object>> getPastSeven();

    List<Map<String,Object>> getDecember(String time);
}
