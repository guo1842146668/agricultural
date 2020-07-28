package com.puyan.shengren.agricultural.service;

import com.puyan.shengren.agricultural.common.Result;
import org.apache.ibatis.annotations.Param;


/**
 * @ClassName: FunctionService
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 15:37
 * @Version: 1.0
 **/
public interface FunctionService {

    Result getFunctionByUserID(Integer userID);

    Result getAllFunctions();

    Result getAll();

    Result allotFunciton(@Param("functiondata") String functiondata, @Param("roleID") Integer roleID);
}
