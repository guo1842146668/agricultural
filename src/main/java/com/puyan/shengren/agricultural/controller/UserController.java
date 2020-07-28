package com.puyan.shengren.agricultural.controller;

import com.puyan.shengren.agricultural.enity.User;
import com.puyan.shengren.agricultural.service.FunctionService;
import com.puyan.shengren.agricultural.service.UserService;
import com.puyan.shengren.agricultural.common.Result;
import com.puyan.shengren.agricultural.common.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 13:55
 * @Version: 1.0
 **/
@Api(value = "UserController", description = "用户操作控制类")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private FunctionService functionService;
    /**
     * @Author guoyangyang
     * @Description  用户登录
     * @Date  2020/7/21 18:14
     * @Param * @param userName: 用户名
     * @param passWord:  密码
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<com.puyan.shengren.agricultural.enity.User>
     *     登录成功返回用户信息   密码已经清空
     **/
    @ApiOperation(value="用户登录", notes="用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "passWord", value = "密码", required = true ,dataType = "string"),
    })
    @GetMapping("/login")
    @ResponseBody
    public ServerResponse<User> login(@Param("userName") String userName, @Param("passWord") String passWord, HttpSession session){
        ServerResponse<User> user=userService.userLogin(userName,passWord);
        if(user!=null){
            Result allFunctions =null;
            if(user.getData().getType() == 1){
                allFunctions = functionService.getAllFunctions();
            }else{
                allFunctions = functionService.getFunctionByUserID(user.getData().getUserID());
            }
            session.setAttribute("user",user);
            session.setAttribute("Functions",allFunctions);
        }
        return user;
    }

    /**
     * @Author guoyangyang
     * @Description  用户注册
     * @Date  2020/7/21 18:13
     * @Param * @param user: 用户form表单
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>  注册成功返回成功信息
     **/
    @ApiOperation(value="创建用户", notes="创建用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true ,dataType = "com.puyan.shengren.agricultural.enity.User"),
    })
    @PostMapping("/register")
    @ResponseBody
    public ServerResponse<String> register(User user){
        return  userService.insert(user);
    }

    /**
     * @Author guoyangyang
     * @Description  通过ID查询个人信息
     * @Date  2020/7/21 18:21
     * @Param * @param id:
     * @return * @return: com.puyan.shengren.agricultural.enity.User
     * 返回查询到的对象
     **/
    @ApiOperation(value="根据ID查用户", notes="根据ID查用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true ,dataType = "Integer"),
    })
    @GetMapping("/getUserById")
    @ResponseBody
    public Result getUserById(@Param("userID") Integer userID){
        return  userService.getUserById(userID);
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
    @ApiOperation(value="修改密码", notes="修改密码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "String"),
            @ApiImplicitParam(name = "passWord", value = "旧密码", required = true ,dataType = "String"),
            @ApiImplicitParam(name = "newPassWord", value = "新密码", required = true ,dataType = "String"),
            @ApiImplicitParam(name = "updator", value = "修改人-当前登录的ID", required = true ,dataType = "Integer"),
    })
    @PutMapping("/forgetResetPassword")
    @ResponseBody
    public  ServerResponse<String> forgetResetPassword(@Param("userName") String userName, @Param("passWord") String passWord,@Param("newPassWord") String newPassWord, @Param("updator") Integer updator){
        return  userService.updatePassWordByUserName(userName,passWord,newPassWord,updator);
    }

    /**
     * @Author guoyangyang
     * @Description  修改人事信息或修改状态
     * @Date  2020/7/22 10:15
     * @Param * @param user:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<java.lang.String>
     **/
    @ApiOperation(value="修改用户信息", notes="修改用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true ,dataType = "com.puyan.shengren.agricultural.enity.User"),
    })
    @PutMapping("/update")
    @ResponseBody
    public Result update(User user) {
      return userService.update(user);
    }

    /**
     * @Author guoyangyang
     * @Description  查询所有用户
     * @Date  2020/7/22 11:00
     * @Param * @param user:
     * @return * @return: com.puyan.shengren.agricultural.common.ServerResponse<com.puyan.shengren.agricultural.enity.User>
     *     返回用户DATA
     **/
    @ApiOperation(value="查询用户信息", notes="查询用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "筛选条件", required = false ,dataType = "com.puyan.shengren.agricultural.enity.User"),
            @ApiImplicitParam(name = "page", value = "分页 - 第几页", required = true ,dataType = "Integer"),
            @ApiImplicitParam(name = "count", value = "分页 - 一页几条数据", required = true ,dataType = "Integer"),
    })
    @GetMapping("/getAll")
    @ResponseBody
    public Result getAll(User user,@Param("page") Integer page,@Param("count") Integer count){
        return userService.getAll(user,page,count);
    }

    /**
     * @Author guoyangyang
     * @Description  修改用户状态
     * @Date  2020/7/22 15:16
     * @Param * @param userID:
     * @param status: 用户状态
     * @return * @return: com.puyan.shengren.agricultural.common.Result
     **/
    @ApiOperation(value="修改用户状态", notes="修改用户状态接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true ,dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "需要修改成的状态", required = true ,dataType = "Integer"),
    })
    @PutMapping("/updateStatus")
    @ResponseBody
    public Result updateStatus(@Param("userID") Integer userID,@Param("status") Integer status){
        return  userService.updateStatus(userID,status);
    }
}
