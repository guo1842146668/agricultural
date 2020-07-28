package com.puyan.shengren.agricultural.Service;

import com.puyan.shengren.agricultural.Enity.User;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ServerResponse;
import org.apache.ibatis.annotations.Param;



/**
 * @ClassName: UserServer
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 14:35
 * @Version: 1.0
 **/
public interface UserService {

    ServerResponse<String> insert(User user);

    ServerResponse<User> userLogin(@Param("userName") String userName, @Param("passWord") String passWord);

    Result getUserById(@Param("id") Integer id);

    ServerResponse<String> updatePassWordByUserName(@Param("userName") String userName, @Param("passWord") String passWord,@Param("newPassWord") String newPassWord, @Param("updator") Integer updator);

    Result update(User user);

    Result getAll(User user,Integer page,Integer count);

    Result updateStatus(@Param("userID") Integer userID,@Param("status") Integer status);
}
