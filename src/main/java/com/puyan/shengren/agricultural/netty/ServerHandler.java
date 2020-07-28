package com.puyan.shengren.agricultural.netty;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.puyan.shengren.agricultural.enity.Machinery;
import com.puyan.shengren.agricultural.enity.Work;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

/**
 * @author JHS
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    //存放Socket连接
    public static TimedCache<String, ChannelHandlerContext> timedCache = CacheUtil.newTimedCache(10000);

    //存放设备与服务器的连接
    public static TimedCache<String, NettyServer> NETTY_SERVER = CacheUtil.newTimedCache(5000);

    //链接
    public static ChannelHandlerContext chc;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        ServerHandler.chc = ctx;
        // 收到消息直接打印输出
        System.err.println(DateUtil.now() + ":" + ctx.channel().remoteAddress().toString().split(":")[0] + " Say : " + msg);
        // 返回客户端消息 - 我已经接收到了你的消息
        ctx.writeAndFlush("111111");
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    ctx.writeAndFlush(":01031C1C005074\r\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        /*if(msg.substring(13,17).equals("BP05")){
            terminalRegistration(msg);
        }*/
    }

    /*
     *
     * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
     *
     * channelActive 和 channelInActive 在后面的内容中讲述，这里先不做详细的描述
     * */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ServerHandler.timedCache.put(ctx.channel().remoteAddress().toString().split(":")[0], ctx);
        System.out.println("地址 : " + ctx.channel().remoteAddress().toString().split(":")[0]);
        //向客户端发送的信息
        //ctx.writeAndFlush("11 00 01 00");
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    ctx.writeAndFlush(":01031C1C005074\r\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        ctx.writeAndFlush("22222");
        super.channelActive(ctx);
    }


    /**
     * 处理终端注册信息
     *
     * @param msg 命令
     */
    public static void terminalRegistration(String msg) {
        //设备编号
        String equipmentNumber = msg.substring(1, 13);
        //IMEI  国际移动设备识别码
        String imei = msg.substring(17, 32);
        //纬度
        String latitude = msg.substring(39, 48);
        //经度
        String longitude = msg.substring(49, 58);
        //里程数
        String mileage = msg.substring(msg.indexOf("L"), msg.indexOf("L") + 9);
        //创建实现类对象

        RestTemplate restTemplate=new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8080/machinery/getMachineryIsEmpty?machineryNO=" + "060047295267", String.class);
        JSONObject jsonObject=new JSONObject(forObject);
        Object code = jsonObject.get("code");
        Object data = jsonObject.get("data");
        if(code !=null && code.toString().equals("200")){
            if(data.toString().equals("null")){
                Machinery machinery=new Machinery();
                machinery.setMachineryNO("060047295267");
                machinery.setMachineryIMEI(imei);
                forObject = restTemplate.postForObject("http://localhost:8080/machinery/machineryInsert",machinery,String.class);
                jsonObject=new JSONObject(forObject);
                code =jsonObject.get("code");
                if(!code.toString().equals("200")){
                    //如果插入失败程序将停止
                    int a =10/0;
                }
            }else{
                Work work=new Work();
                jsonObject=new JSONObject(data);
                Object machineryID = jsonObject.get("machineryID");
                work.setWorkMachineryID(Integer.parseInt(machineryID.toString()));
                work.setWorkStartMap(latitude+","+longitude);
                work.setDrivenDistance(Double.parseDouble(mileage.substring(mileage.indexOf("L")+1,mileage.indexOf("L") + 9)));
                forObject = restTemplate.postForObject("http://localhost:8080/work/work_insert",work,String.class);
                jsonObject=new JSONObject(forObject);
                code =jsonObject.get("code");
                if(!code.toString().equals("200")){
                    //如果插入失败程序将停止
                    int a =10/0;
                }
            }
        }
       /* MachineryServiceImpl machineryService =new MachineryServiceImpl();
        Machinery machinery=new Machinery();
        //判断是否是第一次收到心跳      如果是第一次收到心跳将创建 Machinery 信息
        Result machineryIsEmpty = machineryService.getMachineryIsEmpty(equipmentNumber);
        if(machineryIsEmpty == null){
            machinery.setMachineryNO(equipmentNumber);
            machinery.setMachineryIMEI(imei);
            machinery.setMachineryStatus(1);
            machineryService.insert(machinery);
        }else{
            if(machinery.getMachineryOwner() == null){

            }else{
                machinery=(Machinery)machineryIsEmpty.getData();
                Work work=new Work();
                WorkServiceImpl workService=new WorkServiceImpl();
                work.setWorkMachineryID(machinery.getMachineryID());
                work.setWorkStartMap(latitude+","+longitude);
                work.setDrivenDistance(Double.parseDouble(mileage));
            }
        }*/

    }

    /**
     * 设置 ACC 开终端设备发送间隔
     *
     * @param deviceId     设备ID
     * @param timeInterval 时间间隔
     *                     new BigInteger(timeInterval + "", 10).toString(16)  10进制转16进制
     */
    public static void setTheAccOnTerminalDeviceSendingInterval(String deviceId, Integer timeInterval) {
        String order = "(" + deviceId + "AR05" + zeroPadding(new BigInteger(timeInterval + "", 10).toString(16)) + ")";
    }

    /**
     * 设置 ACC 关终端设备发送间隔
     *
     * @param deviceId
     * @param timeInterval
     */
    public static void setTheAccTerminalEquipmentSendingInterval(String deviceId, Integer timeInterval) {
        String order = "(" + deviceId + "AR06" + zeroPadding(new BigInteger(timeInterval + "", 10).toString(16)) + ")";
    }

    public static void main(String[] args) {
        terminalRegistration("(060047295260BP05867160047295260800106V000000000S0000000000W0000000002200000001000000L00018760)");
        setTheAccOnTerminalDeviceSendingInterval("060047295260", 291);
    }


    /**
     * 补零
     *
     * @return
     */
    public static String zeroPadding(String msg) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            sb.append("0");
        }
        sb.append(msg);
        return msg;
    }
}
