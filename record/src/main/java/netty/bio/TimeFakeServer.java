package  netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-05 16:06
 * @Description:伪异步IO
 */
public class TimeFakeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time is start in port : " + port);
            Socket socket = null;
            //创建I/O任务线程池
            TimeServerHandlerExecutePool singleExecuter = new TimeServerHandlerExecutePool(50,1000);
            while (true) {
                socket = server.accept();
                singleExecuter.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
            }
            server.close();
            server = null;
        }
    }
}
