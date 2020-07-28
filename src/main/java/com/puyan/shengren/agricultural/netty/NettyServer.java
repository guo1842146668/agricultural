package com.puyan.shengren.agricultural.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 需要使用时开启注解，不然会占用端口
 * @author JHS
 */
@Configuration
public class NettyServer {

    Logger logger= LoggerFactory.getLogger("NettyServer");

    @Bean
    public void server() {
        Thread thread=new Thread(){
            @Override
            public void run(){
                EventLoopGroup bossGroup = new NioEventLoopGroup();
                EventLoopGroup workerGroup = new NioEventLoopGroup();
                try {
                    ServerBootstrap b = new ServerBootstrap();
                    b.group(bossGroup, workerGroup);
                    b.channel(NioServerSocketChannel.class);
                    b.childHandler(new ServerInitializer());
                    b.childOption(ChannelOption.WRITE_BUFFER_WATER_MARK,new WriteBufferWaterMark(1,1024*1024*8));
                    // 服务器绑定端口监听
                    ChannelFuture f = b.bind(9091).sync();
                    logger.info("服务器开始监听：9091");
                    // 监听服务器关闭监听
                    f.channel().closeFuture().sync();

                    // 可以简写为
                    /* b.bind(portNumber).sync().channel().closeFuture().sync(); */
                }catch (Exception e){
                    e.printStackTrace();
                } finally {
                    bossGroup.shutdownGracefully();
                    workerGroup.shutdownGracefully();
                }
            }
        };
        thread.start();
    }

}
