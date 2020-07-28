package com.puyan.shengren.agricultural.Dao;

import com.puyan.shengren.agricultural.Enity.Function;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @ClassName: FunctionDao
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 11:07
 * @Version: 1.0
 **/
@Mapper
public interface FunctionDao {

    List<Function> getAllByUserID(Integer userID);

    List<Function> getAllFunctions();

    List<Function> getAll();

    int getFunctionByfunctionID(Integer roleID,Integer functionID);

    int insert(Integer roleID,Integer functionID);
}
