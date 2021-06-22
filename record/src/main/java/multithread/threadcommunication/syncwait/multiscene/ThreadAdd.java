package multithread.threadcommunication.syncwait.multiscene;

/**
 * @author sunxiaoyu3
 * @description 元素添加线程
 * @createTime 2021/06/22 14:33:00
 */
public class ThreadAdd extends Thread {

    private String lock;

    public ThreadAdd(String lock, String name) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();               // 唤醒所有 wait 线程
        }
    }
}
