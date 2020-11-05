package netty.start;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-12 19:57
 * @Description: 用于对网络事件的读写操作
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        //获取缓冲区可读的字节数
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("The time server receive order ：" + body);
        String currentTime = "QUERY TIME OREDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将消息发送队列的消息写入到SocketChannel中发送给对方
        //从性能角度来考虑，为了防止频繁的唤醒Selector进行消息发送，Netty的write方法并不是直接将消息写入SocketChannel中，
        //调用write方法是把待发送的消息放到缓冲数组中，再通过调用flush方法，将发送缓冲区中的消息全部写到SocketChannel中
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
