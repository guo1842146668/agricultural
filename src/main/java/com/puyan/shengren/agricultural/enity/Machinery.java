package com.puyan.shengren.agricultural.enity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: Machinery //农业机械表 agricultural_machinery
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 10:49
 * @Version: 1.0
 **/
@ApiModel(value="Machinery对象",description="农业机械对象Machinery")
public class Machinery {
    @ApiModelProperty(value = "农业机械ID",hidden = true)
    private Integer machineryID;
    @ApiModelProperty(value = "农业机械所有者ID")
    private Integer machineryOwner;
    @ApiModelProperty(value = "农业机械编号")
    private String machineryNO;
    @ApiModelProperty(value = "国际移动设备识别码")
    private String machineryIMEI;
    @ApiModelProperty(value = "农业机械车牌号")
    private String machineryLicense;
    @ApiModelProperty(value = "农业机械品牌")
    private String machineryBrand;
    @ApiModelProperty(value = "农业机械宽度")
    private Double machineryWidth;
    @ApiModelProperty(value = "农机状态  1正常   2损坏  3维修  4报废删除")
    private Integer machineryStatus;
    @ApiModelProperty(value = "持有者对象",dataType = "com.puyan.shengren.agricultural.Enity.User")
    private User user;

    public Machinery(Integer machineryID, Integer machineryOwner, String machineryNO, String machineryIMEI, String machineryLicense, String machineryBrand, Double machineryWidth, Integer machineryStatus, User user) {
        this.machineryID = machineryID;
        this.machineryOwner = machineryOwner;
        this.machineryNO = machineryNO;
        this.machineryIMEI = machineryIMEI;
        this.machineryLicense = machineryLicense;
        this.machineryBrand = machineryBrand;
        this.machineryWidth = machineryWidth;
        this.machineryStatus = machineryStatus;
        this.user = user;
    }

    public Machinery() {
    }

    public Integer getMachineryID() {
        return machineryID;
    }

    public void setMachineryID(Integer machineryID) {
        this.machineryID = machineryID;
    }

    public Integer getMachineryOwner() {
        return machineryOwner;
    }

    public void setMachineryOwner(Integer machineryOwner) {
        this.machineryOwner = machineryOwner;
    }

    public String getMachineryNO() {
        return machineryNO;
    }

    public void setMachineryNO(String machineryNO) {
        this.machineryNO = machineryNO;
    }

    public String getMachineryIMEI() {
        return machineryIMEI;
    }

    public void setMachineryIMEI(String machineryIMEI) {
        this.machineryIMEI = machineryIMEI;
    }

    public String getMachineryLicense() {
        return machineryLicense;
    }

    public void setMachineryLicense(String machineryLicense) {
        this.machineryLicense = machineryLicense;
    }

    public String getMachineryBrand() {
        return machineryBrand;
    }

    public void setMachineryBrand(String machineryBrand) {
        this.machineryBrand = machineryBrand;
    }

    public Double getMachineryWidth() {
        return machineryWidth;
    }

    public void setMachineryWidth(Double machineryWidth) {
        this.machineryWidth = machineryWidth;
    }

    public Integer getMachineryStatus() {
        return machineryStatus;
    }

    public void setMachineryStatus(Integer machineryStatus) {
        this.machineryStatus = machineryStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
