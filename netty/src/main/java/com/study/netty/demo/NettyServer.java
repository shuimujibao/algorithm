package com.study.netty.demo;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author sunxiaoyu3
 * @description netty服务端
 * @createTime 2021/03/25 23:08:00
 */
public class NettyServer {
    public static void main(String[] args) {
        /**
         * 新建两个线程组
         *<p>
         *  Boss线程组启动一条线程，监听OP_ACCEPT事件
         *
         *  Worker线程组默认启动CPU核数*2的线程
         *  监听客户端连接的OP_READ和OP_WRITE事件，处理I/O事件
         * </p>
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup(1);

        //Netty服务启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup);

        try {
            /**
             * 设置TCP Socket通道为 {@link  NioServerSocketChannel}
             * 若是UDP通信，则将其设置为 {@link  DatagramChannel}
             */
            serverBootstrap.channel(NioServerSocketChannel.class);

            //设置一些TCP参数
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 128).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                    /**
                     *
                     */
                    ch.pipeline().addLast(new ServerHandler());
                }
            });

            //同步绑定端口
            ChannelFuture future = serverBootstrap.bind(8080).sync();

            //阻塞主线程，知道socket通道被关闭
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //最终关闭线程
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
