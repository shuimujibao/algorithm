package netty.nio;


import java.io.IOException;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-05 14:57
 * @Description: 同步非阻塞IO -- NIO
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTime-001").start();
    }
}
