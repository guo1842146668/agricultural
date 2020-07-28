package com.puyan.shengren.agricultural.Dao;

import com.puyan.shengren.agricultural.Enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 13:56
 * @Version: 1.0
 **/
@Mapper
public interface UserDao {

        int insert(User user);

        User userLogin(@Param("userName") String userName, @Param("passWord") String passWord);

        User getUserById(@Param("id") Integer id);

        int updatePassWordByUserName(@Param("userName") String userName, @Param("passWord") String passWord, @Param("updator") Integer updator);

        int update(User user);

        List<User> getAll(User user);

        int updateStatus(@Param("userID") Integer userID,@Param("status") Integer status);
}
