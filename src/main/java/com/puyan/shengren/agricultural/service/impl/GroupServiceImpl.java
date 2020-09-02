package com.puyan.shengren.agricultural.service.impl;

import com.puyan.shengren.agricultural.dao.GroupDao;
import com.puyan.shengren.agricultural.enity.Group;
import com.puyan.shengren.agricultural.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author idmin
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Resource
    private GroupDao groupDao;

    @Override
    public int saveGroup(String groupName,Integer createUserID) {
        Map<String,Object> map=new HashMap<>();
        map.put("groupName",groupName);
        map.put("createUserID",createUserID);
        return groupDao.saveGroup(map);
    }

    @Override
    public List<Group> listGroup(Integer UserID) {
        return groupDao.listGroup(UserID);
    }
}
