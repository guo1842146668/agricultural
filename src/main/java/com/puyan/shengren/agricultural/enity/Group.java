package com.puyan.shengren.agricultural.enity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author idmin
 */
@ApiModel(value="Group对象",description="分组对象Group")
public class Group {
    @ApiModelProperty(value = "分组对象ID",hidden = true)
    private Integer groupID;
    @ApiModelProperty(value = "分组名称")
    private String groupName;
    @ApiModelProperty(value = "分组状态")
    private Integer groupStatus;

    public Group() {
    }

    public Group(Integer groupID, String groupName, Integer groupStatus) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupStatus = groupStatus;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }
}
