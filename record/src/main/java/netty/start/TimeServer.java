package  netty.start;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-10 16:59
 * @Description: netty服务端开发
 */
public class TimeServer {
    public void bind(int port) throws Exception {
        //配置服务端的NIO线程组，NioEventLoopGroup是个线程组，它包含了一组NIO线程专门用于处理网络事件，实际上他们就是Reactor线程组
        //一个用于服务端接受客户端的连接，一个用于进行SocketChannel的网络读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //用于启动NIO服务端的辅助启动类，目的是降低服务端的开发复杂度
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(port)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHanlder());
            //绑定端口，同步等待成功
            ChannelFuture f = b.bind().sync();
            //等待服务器监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            //优雅的退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    //绑定I/O事件处理类，作用类似于Reactor模式中的Handler类
    private class ChildChannelHanlder extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel arg0) throws Exception {
            arg0.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        new TimeServer().bind(port);
    }
}
