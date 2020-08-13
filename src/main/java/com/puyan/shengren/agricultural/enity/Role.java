package com.puyan.shengren.agricultural.enity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * @ClassName: Role  //角色表agricultural_role
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 14:03
 * @Version: 1.0
 **/
@ApiModel(value="Role对象",description="角色对象Role")
public class Role {
    @ApiModelProperty(value = "角色ID",hidden = true)
    private Integer roleID;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "创建人")
    private Integer creator;
    @ApiModelProperty(value = "修改时间")
    private Date updateDate;
    @ApiModelProperty(value = "修改人")
    private Integer updator;
    @ApiModelProperty(value = "状态 1正常    -1禁用")
    private Integer status;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Role(Integer roleID, String roleName, Date createDate, Integer creator, Date updateDate, Integer updator, Integer status, String remark) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.createDate = createDate;
        this.creator = creator;
        this.updateDate = updateDate;
        this.updator = updator;
        this.status = status;
        this.remark = remark;
    }

    public Role() {
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
