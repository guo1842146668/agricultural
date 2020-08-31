package com.puyan.shengren.agricultural.service.impl;

import com.puyan.shengren.agricultural.dao.GroupDao;
import com.puyan.shengren.agricultural.enity.Group;
import com.puyan.shengren.agricultural.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author idmin
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Resource
    private GroupDao groupDao;

    @Override
    public int saveGroup(String groupName) {
        return groupDao.saveGroup(groupName);
    }

    @Override
    public List<Group> listGroup(Integer UserID) {
        return groupDao.listGroup(UserID);
    }
}
