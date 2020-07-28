package com.puyan.shengren.agricultural.service;

import com.puyan.shengren.agricultural.common.Result;

/**
 * @ClassName: StatService
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 15:46
 * @Version: 1.0
 **/
public interface StatService {

    Result getAllByCounty(Integer page,Integer count);

    Result getAllByMachineryID(Integer page,Integer count);

    Result getStatsWookNum();

    Result getPastSeven();
}