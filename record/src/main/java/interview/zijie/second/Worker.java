package interview.zijie.second;

import java.util.concurrent.CyclicBarrier;

/**
 * @author sunxiaoyu3
 * @description 一个线程
 * @createTime 2021/01/25 14:09:00
 */
public class Worker implements Runnable {

    private CyclicBarrier cyclicBarrier;

    Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "阻塞中：" + Thread.currentThread().getId());
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + "开始执行：" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
