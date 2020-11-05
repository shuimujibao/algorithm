package netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-05 15:37
 * @Description:
 */
public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采取默认值
            }
        }

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server succeed");
            String resp = in.readLine();
            System.out.println("Now is" + resp);
        } catch (Exception e) {
            //不需要处理
        } finally {
            if (out != null) {
                out.close();
                out = null;
            }
            if (in != null) {
                in.close();
            }
            in = null;
            if (socket != null) {
                socket.close();
            }
            socket = null;
        }
    }
}
