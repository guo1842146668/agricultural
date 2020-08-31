package com.puyan.shengren.agricultural.dao;

import com.puyan.shengren.agricultural.enity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author idmin
 */
@Mapper
public interface GroupDao {
    /**
     * 录入分组信息
     * @param groupName 分组名称
     * @return 录入成功否
     */
    int saveGroup(String groupName);

    /**
     * 查询所有分组信息
     * @return 分组信息
     */
    List<Group> listGroup(Integer UserID);

}
