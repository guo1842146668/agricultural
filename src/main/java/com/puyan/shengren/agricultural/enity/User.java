package com.puyan.shengren.agricultural.enity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName: User   //用户表  agricultural_user
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 13:57
 * @Version: 1.0
 **/
@ApiModel(value="user对象",description="用户对象user")
public class User {
    @ApiModelProperty(value = "用户ID",hidden = true)
    private Integer userID;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String passWord;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "人事类型")
    private Integer type;
    @ApiModelProperty(value = "用户状态 1正常    -1禁用")
    private Integer status;
    @ApiModelProperty(value = "上一次登录时间")
    private Date lastLoginTime;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "创建人")
    private Integer creator;
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;
    @ApiModelProperty(value = "更新人")
    private Integer updator;
    @ApiModelProperty(value = "省")
    private String uprovince;
    @ApiModelProperty(value = "市")
    private String ucity;
    @ApiModelProperty(value = "县")
    private String ucounty;
    @ApiModelProperty(value = "镇")
    private String utown;
    @ApiModelProperty(value = "村")
    private String uvillage;
    @ApiModelProperty(value = "合作社")
    private String ucooperative;
    @ApiModelProperty(value = "分组ID")
    private Integer groupID;

    public User() {
    }

    public User(Integer userID, String userName, String passWord, String phone, String email, Integer type, Integer status, Date lastLoginTime, Date createDate, Integer creator, Date updateDate, Integer updator, String uprovince, String ucity, String ucounty, String utown, String uvillage, String ucooperative, Integer groupID) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.status = status;
        this.lastLoginTime = lastLoginTime;
        this.createDate = createDate;
        this.creator = creator;
        this.updateDate = updateDate;
        this.updator = updator;
        this.uprovince = uprovince;
        this.ucity = ucity;
        this.ucounty = ucounty;
        this.utown = utown;
        this.uvillage = uvillage;
        this.ucooperative = ucooperative;
        this.groupID = groupID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdator() {
        return updator;
    }

    public void setUpdator(Integer updator) {
        this.updator = updator;
    }

    public String getUprovince() {
        return uprovince;
    }

    public void setUprovince(String uprovince) {
        this.uprovince = uprovince;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public String getUcounty() {
        return ucounty;
    }

    public void setUcounty(String ucounty) {
        this.ucounty = ucounty;
    }

    public String getUtown() {
        return utown;
    }

    public void setUtown(String utown) {
        this.utown = utown;
    }

    public String getUvillage() {
        return uvillage;
    }

    public void setUvillage(String uvillage) {
        this.uvillage = uvillage;
    }

    public String getUcooperative() {
        return ucooperative;
    }

    public void setUcooperative(String ucooperative) {
        this.ucooperative = ucooperative;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }
}
