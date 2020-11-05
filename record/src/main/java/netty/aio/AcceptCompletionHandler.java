package  netty.aio;


import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-10 14:11
 * @Description: 通过AcceptCompletionHandler实例作为handler来接受通知消息
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        /*
         *一个asynchronousServerSocketChannel可以接受成千上万个客户端，所以要继续调用它的accept方法，接受其他的客户端连接，最终形成一个循环
         * 每当接受一个客户读连接成功之后，再异步接受新的客户连接
         */
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        /*
         * 链路建立成功后，服务端需要接受客户端的请求消息，预分配1MB的缓冲区
         */
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /*
         * ByteBuffer dst : 接收缓冲区，用于异步Channel中读取数据包
         * A attachment : 异步Channel携带的附件，通知回调的时候作为入参使用
         * CompletionHandler<Integer,? super A>：接受通知回调的业务Handler
         */
        result.read(buffer, buffer, new ReadCompletionHanlder(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
