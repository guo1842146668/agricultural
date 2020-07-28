package com.puyan.shengren.agricultural.Service;

import com.puyan.shengren.agricultural.Enity.Machinery;
import com.puyan.shengren.agricultural.common.Result;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: MachineryService
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 13:39
 * @Version: 1.0
 **/
public interface MachineryService {

    Result insert(Machinery machinery);

    Result updateStarus(Integer machineryID,Integer machineryStatus);

    Result update(Machinery machinery);

    Result getAll(Machinery Machinery,Integer page,Integer count);

    Result getMachineryIsEmpty(String machineryNO);
}
