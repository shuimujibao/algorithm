package multithread.threadcommunication.syncwait.multiscene;

/**
 * @author sunxiaoyu3
 * @description 元素删除线程
 * @createTime 2021/06/22 14:33:00
 */
public class ThreadSubtract extends Thread {

    private String lock;

    public ThreadSubtract(String lock, String name) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size=" + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
