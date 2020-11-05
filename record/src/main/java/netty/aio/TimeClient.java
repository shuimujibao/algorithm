package  netty.aio;

/**
 * @Auther: sunxiaoyu
 * @Date: 2019-12-10 15:44
 * @Description:
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        try {
            port = Integer.valueOf(args[0]);
        }catch (NumberFormatException e){
            //采取默认值
        }
        new Thread(new AsyncTimeClienyHandler("127.0.0.1",port),"AIP-AsyncTimeClientHandler-001").start();
    }
}
