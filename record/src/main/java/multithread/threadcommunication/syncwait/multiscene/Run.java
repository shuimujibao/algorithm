package multithread.threadcommunication.syncwait.multiscene;

/**
 * @author sunxiaoyu3
 * @description 测试类
 * @createTime 2021/06/22 14:35:00
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {

        //锁对象
        String lock = new String("");

        ThreadSubtract subtract1Thread = new ThreadSubtract(lock, "subtract1Thread");
        subtract1Thread.start();

        ThreadSubtract subtract2Thread = new ThreadSubtract(lock, "subtract2Thread");
        subtract2Thread.start();

        Thread.sleep(1000);

        ThreadAdd addThread = new ThreadAdd(lock, "addThread");
        addThread.start();

    }
}
