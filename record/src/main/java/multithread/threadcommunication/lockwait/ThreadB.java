package multithread.threadcommunication.lockwait;

/**
 * @author sunxiaoyu3
 * @description 线程 B
 * @createTime 2021/06/22 14:50:00
 */
public class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
