package com.puyan.shengren.agricultural.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.puyan.shengren.agricultural.dao.FunctionDao;
import com.puyan.shengren.agricultural.dao.UserDao;
import com.puyan.shengren.agricultural.enity.User;
import com.puyan.shengren.agricultural.service.UserService;
import com.puyan.shengren.agricultural.common.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 14:36
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private FunctionDao functionDao;

        /**
         * @Author guoyangyang
         * @Description  用户注册
         * @Date  2020/7/21 18:13
         * @Param * @param user: 用户form表单
         * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
         *    注册成功返回成功信息
         **/
    @Override
    public ServerResponse<String> insert(User user) {
        //StrUtil.hasBlank 糊涂工具包判断空方法
        if(StrUtil.hasBlank(user.getUserName())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"用户名不允许为空");
        }
        if(StrUtil.hasBlank(user.getPassWord())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"用密码不允许为空");
        }
        if(StrUtil.hasBlank(user.getPhone())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"用电话不允许为空");
        }
        //密码加密
        user.setPassWord(SecureUtil.md5(user.getPassWord()));
        //初始状态为 1
        user.setType(2);
        user.setStatus(1);
        int resCount=userDao.insert(user);
        if(resCount==0){
            return ServerResponse.createByError(RegisterEnum.REGISTER_ERROR.getMsg());
        }
        return ServerResponse.createBySuccessMessage(RegisterEnum.REGISTER_SUCESS.getMsg());

    }

    /**
     * @Author guoyangyang
     * @Description  用户登录
     * @Date  2020/7/21 18:14
     * @Param * @param userName: 用户名
     * @param passWord:  密码
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<com.puyan.shengren.agricultural.Enity.User>
     *     登录成功返回用户信息密码除外
     **/
    @Override
    public ServerResponse<User> userLogin(String userName, String passWord) {
        if(StrUtil.hasBlank(userName)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"用户名不允许为空");
        }
        if(StrUtil.hasBlank(passWord)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"用密码不允许为空");
        }
        User user=userDao.userLogin(userName,SecureUtil.md5(passWord));
        //返回的数据密码需要清空
        if(user!=null){
            if(user.getStatus() > 0){
                user.setPassWord("");
                return ServerResponse.createBySuccess(LoginEnum.LOGIN_SUCCESS.getMsg(),user);
            }else{
                return ServerResponse.createByError("用户已被禁用");
            }
        }
        return ServerResponse.createByError(LoginEnum.ERROR_PASSWORD.getMsg());
    }

    /**
     * @Author guoyangyang
     * @Description  通过ID查询个人信息
     * @Date  2020/7/21 18:21
     * @Param * @param id:
     * @return * @return: com.puyan.shengren.agricultural.enity.User
     * 返回查询到的对象
     **/
    @Override
    public Result getUserById(Integer id) {
        User userById = userDao.getUserById(id);
        if(userById !=null){
            userById.setPassWord("");
            return  ResultUtil.success(userById);
        }
        return  ResultUtil.success(userById);
    }

    /**
     * @Author guoyangyang
     * @Description  更换密码
     * @Date  2020/7/21 18:53
     * @Param * @param userName: 用户名
     * @param passWord: 原来的密码
     * @param newPassWord: 新密码
     * @param updator: 修改人
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
     *     返回更换结果成功或失败
     **/
    @Override
    public ServerResponse<String> updatePassWordByUserName(String userName, String passWord, String newPassWord, Integer updator) {
        ServerResponse<User> userServerResponse = userLogin(userName, passWord);
        if(userServerResponse.getData()!=null){
            int resCount = userDao.updatePassWordByUserName(userName, SecureUtil.md5(newPassWord), updator);
            if(resCount==0){
                return ServerResponse.createByError(ResponseCode.ERROR.getDesc());
            }else{
                return ServerResponse.createBySuccessMessage(ResponseCode.SUCCESS.getDesc());
            }
        }
        return ServerResponse.createByError(LoginEnum.ERROR_PASSWORD.getMsg());
    }

    /**
     * @Author guoyangyang
     * @Description  修改人事信息
     * @Date  2020/7/22 10:13
     * @Param * @param user:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
     **/
    @Override
    public Result update(User user) {
        if(StrUtil.hasBlank(user.getUserName())){
            return ResultUtil.error(500,"用户名不允许为空");
        }
        int resConut=userDao.update(user);
        if(resConut==0){
            return ResultUtil.error(400,"更新失败");
        }
        return ResultUtil.success();
    }

    /**
     * @Author guoyangyang
     * @Description  查询所有用户
     * @Date  2020/7/22 10:58
     * @Param * @param user:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<com.puyan.shengren.agricultural.Enity.User>
     *     返回用户DATA
     **/
    @Override
    public Result getAll(User user,Integer page,Integer count) {
        //开启分页
        PageHelper.startPage(page,count);
        List<User> userAll = userDao.getAll(user);
        if(userAll.isEmpty()){
            return ResultUtil.success(userAll);
        }
        //创建分页对象
        PageInfo<User> pageInfo=new PageInfo<>(userAll);
        //分页封装返回
        return ResultUtil.success(pageInfo);
    }

    /**
     * @Author guoyangyang
     * @Description  修改用户状态
     * @Date  2020/7/22 15:12
     * @Param * @param userID:
     * @param status: 用户状态
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @Override
    public Result updateStatus(Integer userID, Integer status) {
        int resCount=userDao.updateStatus(userID,status);
        if(resCount == 0){
            return  ResultUtil.error(400,"更新失败");
        }
        return ResultUtil.success();
    }

    @Override
    public Result verificationResults() {
        return ResultUtil.success(userDao.verificationResults());
    }

}
