package com.puyan.shengren.agricultural.Service.Impl;

import com.puyan.shengren.agricultural.Dao.FunctionDao;
import com.puyan.shengren.agricultural.Enity.Function;
import com.puyan.shengren.agricultural.Service.FunctionService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: FunctionServiceImpl
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 15:37
 * @Version: 1.0
 **/
@Service
public class FunctionServiceImpl implements FunctionService {
    @Resource
    private FunctionDao functionDao;

    /**
     * @Author guoyangyang
     * @Description  根据用户ID查询对应权限
     * @Date  2020/7/22 15:42
     * @Param * @param userID:
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @Override
    public Result getFunctionByUserID(Integer userID) {
        return ResultUtil.success(functionDao.getAllByUserID(userID));
    }

    @Override
    public Result getAllFunctions() {
        return ResultUtil.success(functionDao.getAllFunctions());
    }

    /**
     * @Author guoyangyang
     * @Description  获取所有可用权限 将用户角色选择权限
     * @Date  2020/7/22 15:47
     * @Param
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @Override
    public Result getAll() {
        return ResultUtil.success(functionDao.getAll());
    }

    @Override
    public Result allotFunciton(String functiondata, Integer roleID) {
        if(functiondata.length()>0){
            String[] array=functiondata.split(",");
            for (int i = 0; i < array.length; i++) {
                if (functionDao.getFunctionByfunctionID(roleID,Integer.parseInt(array[i]))<1){
                    functionDao.insert(roleID,Integer.parseInt(array[i]));
                }
            }
            return ResultUtil.success();
        }
        return ResultUtil.error(500,"functiondata不可为空");
    }


}
