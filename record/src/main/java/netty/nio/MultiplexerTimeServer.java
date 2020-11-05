package  netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-05 16:26
 * @Description:
 */
public class MultiplexerTimeServer implements Runnable {
    private Selector selector;
    private ServerSocketChannel serverChannel;
    private volatile boolean stop;
    private ByteBuffer readBuffer;

    /**
     * 初始化多路复用器，绑定监听端口
     */
    public MultiplexerTimeServer(int port) {
        try {
            /**
             * 多路复用器(Selector)会不断轮询注册在其上的管道（Channel）
             * 如果某个channel上面发生读或者写的事件，这个channel就处于就绪状态，会被Selector轮询出来，通过SelectionKey可以获取就绪的Channel的集合，进行后续的I/O操作
             * 一个多路复用器同时可以轮询多个Channel
             * JDK使用了epoll()代替了传统的select实现，没有最大句柄1024/2048的限制
             * 只需要一个线程负责选择器的轮询就可以接入成千上万的客户端
             */
            selector = Selector.open();
            //用于监听客户端的连接，它是所有客户端连接的父管道
            serverChannel = ServerSocketChannel.open();
            //设置连接为非阻塞
            serverChannel.configureBlocking(false);
            //绑定监听端口
            serverChannel.socket().bind(new InetSocketAddress(port), 1024);
            //将ServerSocketChannel注册到Reactor线程的多路复用器Selector上，监听Accept事件
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port ：" + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                //轮询出准备就绪的Key
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        //处理I/O事件
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.channel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        //多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以并不需要重复释放资源
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            //处理新接入的请求消息
            if (key.isAcceptable()) {
                //Accept the new connection
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                //多路复用器监听到新的客户端接入，处理新的接入请求，完成tcp三次握手，建立物理链路
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                //Add the new connection to selector
                sc.register(selector, SelectionKey.OP_READ);
            }

            if (key.isReadable()) {
                //Read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time receive order : " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    //对链路关闭
                    key.cancel();
                    sc.close();
                } else {
                    //读到0字节，忽略
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if(response != null && response.trim().length() > 0){
          byte[] bytes = response.getBytes();
          ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
          writeBuffer.put(bytes);
          writeBuffer.flip();
          channel.write(writeBuffer);
        }
    }
}
