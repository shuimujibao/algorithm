package interview.didi.second;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunxiaoyu3
 * @description worker线程
 * @createTime 2020/11/13 20:38:00
 */
public class Worker implements Runnable {

    private int threadId;

    private CountDownLatch countDownLatch;

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private int n = 1;

    Worker(int threadId, CountDownLatch countDownLatch) {
        this.threadId = threadId;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (n > 10) {
                    break;
                }

                if (n % 3 == this.threadId) {
                    try {
                        System.out.println("线程No:" + threadId + "*******" + (n++));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                } else {
                    try {
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                condition.signalAll();
            }
        }
    }

    private void count() {
        try {
            System.out.println("线程No:" + threadId + "*******" + (n++));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
