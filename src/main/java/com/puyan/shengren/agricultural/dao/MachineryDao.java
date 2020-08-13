package com.puyan.shengren.agricultural.dao;

import com.puyan.shengren.agricultural.enity.Machinery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: MachineryDao
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 11:05
 * @Version: 1.0
 **/
@Mapper
public interface MachineryDao {

    int insert(Machinery machinery);

    int updateStarus(Integer machineryID,Integer machineryStatus);

    int update(Machinery machinery);

    List<Machinery> getAll(Machinery Machinery);

    Machinery getMachineryIsEmpty(String machineryNO);

    int deleteMachinery(Integer machineryID);

    int deleteWork(Integer machineryID);
}
