package interview.didi.second;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/11/17 18:18:00
 */
public class Worker2 implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition c = lock.newCondition();

    private int threadNo;

    private static int count = 0;

    Worker2(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (count % 3 != this.threadNo) {
                    if (count >= 101) {
                        break;
                    }
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count >= 101) {
                    break;
                }
                System.out.println("thread-" + this.threadNo + ":" + count);
                count++;

                c.signalAll();

            } finally {
                lock.unlock();
            }
        }
    }
}
