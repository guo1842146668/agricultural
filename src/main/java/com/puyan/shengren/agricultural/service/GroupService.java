package com.puyan.shengren.agricultural.service;

import com.puyan.shengren.agricultural.enity.Group;

import java.util.List;

/**
 * @author idmin
 */
public interface GroupService {
    /**
     * 录入分组信息
     * @param groupName 分组名称
     * @return 录入成功否
     */
    int saveGroup(String groupName,Integer createUserID);

    /**
     * 查询所有分组信息
     * @return 分组信息
     */
    List<Group> listGroup(Integer UserID);
}
