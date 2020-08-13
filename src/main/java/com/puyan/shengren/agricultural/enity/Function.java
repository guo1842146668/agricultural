package com.puyan.shengren.agricultural.enity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: Function //方法表 agricultural_function
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/22 11:05
 * @Version: 1.0
 **/
@ApiModel(value="Function对象",description="方法对象Function")
public class Function {
    @ApiModelProperty(value = "方法对象ID",hidden = true)
    private Integer functionID;
    @ApiModelProperty(value = "方法名称")
    private String functionName;
    @ApiModelProperty(value = "访问路径")
    private String linkedUrl;
    @ApiModelProperty(value = "父级ID")
    private Integer parentID;
    @ApiModelProperty(value = "统计顺序")
    private Integer orderNum;
    @ApiModelProperty(value = "方法是否可用")
    private Integer status;

    public Function(Integer functionID, String functionName, String linkedUrl, Integer parentID, Integer orderNum, Integer status) {
        this.functionID = functionID;
        this.functionName = functionName;
        this.linkedUrl = linkedUrl;
        this.parentID = parentID;
        this.orderNum = orderNum;
        this.status = status;
    }

    public Function() {
    }

    public Integer getFunctionID() {
        return functionID;
    }

    public void setFunctionID(Integer functionID) {
        this.functionID = functionID;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getLinkedUrl() {
        return linkedUrl;
    }

    public void setLinkedUrl(String linkedUrl) {
        this.linkedUrl = linkedUrl;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
