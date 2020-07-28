package com.puyan.shengren.agricultural.Dao;

import com.puyan.shengren.agricultural.Enity.Work;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: WorkDao
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 14:03
 * @Version: 1.0
 **/
@Mapper
public interface WorkDao {

    int insert(Work work);

    int delete(Integer workID);

    int update(Work work);

    //List<Map<String,Object>> getAll(Map<String,Object> map);

    List<Work> getAll(Work work);
}
