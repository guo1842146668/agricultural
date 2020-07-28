package com.puyan.shengren.agricultural.tool;

/**
 * @ClassName: Tool
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/24 15:53
 * @Version: 1.0
 **/
public class CalculateUtil {
    //地球平均半径
    private  final double EARTH_RADIUS = 6378137;
    //把经纬度转为度（°）
    private  double rad(double d){
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为千米
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public  double getDistance(double lng1, double lat1, double lng2, double lat2){
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(
                Math.sqrt(
                        Math.pow(Math.sin(a/2),2)
                                + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)
                )
        );
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s/1000;
    }

}
