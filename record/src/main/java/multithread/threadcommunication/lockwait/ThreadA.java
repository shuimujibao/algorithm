package multithread.threadcommunication.lockwait;

/**
 * @author sunxiaoyu3
 * @description 线程 A
 * @createTime 2021/06/22 14:50:00
 */
public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
