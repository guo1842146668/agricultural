package com.puyan.shengren.agricultural.enity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @ClassName: Work //作业表  agricultural_work
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/23 10:53
 * @Version: 1.0
 **/
@ApiModel(value="Work对象",description="作业对象Work")
public class Work {
    @ApiModelProperty(value = "作业ID",hidden = true)
    private Integer workID;
    @ApiModelProperty(value = "作业的机械ID")
    private Integer workMachineryID;
    @ApiModelProperty(value = "作业开始时间")
    private LocalDateTime workStartTime;
    @ApiModelProperty(value = "作业开始坐标")
    private String workStartMap;
    @ApiModelProperty(value = "作业结束时间")
    private LocalDateTime workEndTime;
    @ApiModelProperty(value = "作业结束坐标")
    private String workEndMap;
    @ApiModelProperty(value = "行驶里程")
    private Double drivenDistance;
    @ApiModelProperty(value = "作业里程")
    private Double workLength;
    @ApiModelProperty(value = "作业面积")
    private Double workArea;
    @ApiModelProperty(value = "作业深度")
    private Double workDepth;
    @ApiModelProperty(value = "核对结果 1通过   -1不通过")
    private Integer verificationResults;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "县")
    private String county;
    @ApiModelProperty(value = "镇")
    private String town;
    @ApiModelProperty(value = "村")
    private String village;
    @ApiModelProperty(value = "作业机械对象")
    private Machinery machinery;

    public Work(Integer workID, Integer workMachineryID, LocalDateTime workStartTime, String workStartMap, LocalDateTime workEndTime, String workEndMap, Double drivenDistance, Double workLength, Double workArea, Double workDepth, Integer verificationResults, String province, String city, String county, String town, String village, Machinery machinery) {
        this.workID = workID;
        this.workMachineryID = workMachineryID;
        this.workStartTime = workStartTime;
        this.workStartMap = workStartMap;
        this.workEndTime = workEndTime;
        this.workEndMap = workEndMap;
        this.drivenDistance = drivenDistance;
        this.workLength = workLength;
        this.workArea = workArea;
        this.workDepth = workDepth;
        this.verificationResults = verificationResults;
        this.province = province;
        this.city = city;
        this.county = county;
        this.town = town;
        this.village = village;
        this.machinery = machinery;
    }

    public Work() {
    }

    public Integer getWorkID() {
        return workID;
    }

    public void setWorkID(Integer workID) {
        this.workID = workID;
    }

    public Integer getWorkMachineryID() {
        return workMachineryID;
    }

    public void setWorkMachineryID(Integer workMachineryID) {
        this.workMachineryID = workMachineryID;
    }

    public LocalDateTime getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(LocalDateTime workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkStartMap() {
        return workStartMap;
    }

    public void setWorkStartMap(String workStartMap) {
        this.workStartMap = workStartMap;
    }

    public LocalDateTime getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(LocalDateTime workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getWorkEndMap() {
        return workEndMap;
    }

    public void setWorkEndMap(String workEndMap) {
        this.workEndMap = workEndMap;
    }

    public Double getDrivenDistance() {
        return drivenDistance;
    }

    public void setDrivenDistance(Double drivenDistance) {
        this.drivenDistance = drivenDistance;
    }

    public Double getWorkLength() {
        return workLength;
    }

    public void setWorkLength(Double workLength) {
        this.workLength = workLength;
    }

    public Double getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Double workArea) {
        this.workArea = workArea;
    }

    public Double getWorkDepth() {
        return workDepth;
    }

    public void setWorkDepth(Double workDepth) {
        this.workDepth = workDepth;
    }

    public Integer getVerificationResults() {
        return verificationResults;
    }

    public void setVerificationResults(Integer verificationResults) {
        this.verificationResults = verificationResults;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }
}
