package interview.beike.second;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunxiaoyu3
 * @description 三个线程循环，有序的打印1到20
 * @createTime 2020/11/06 14:35:00
 */
public class Worker implements Runnable {

    private ReentrantLock lock = new ReentrantLock();

    private Integer maxMount;

    private Integer threadMount;

    private Integer threadNo;

    private Integer currentNum = 0;

    Worker(Integer threadNo, Integer maxMount, Integer threadMount) {
        this.threadNo = threadNo;
        this.maxMount = maxMount;
        this.threadMount = threadMount;
    }

    @Override
    public void run() {
        synchronized (Worker.class) {
            while (currentNum < maxMount) {
                currentNum++;
                System.out.println("当前线程ID : " + Thread.currentThread().getName() + " +------+  currentNum :" + currentNum);
            }

        }
    }

}
