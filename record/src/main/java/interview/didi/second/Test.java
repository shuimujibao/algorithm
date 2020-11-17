package interview.didi.second;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunxiaoyu3
 * @description 三个线程交替打印一到100 主线程打印完毕
 * @createTime 2020/11/13 20:36:00
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(10);

        int n = 10;

        for (int i = 0; i < 3; i++) {
            pool.submit(new Worker(i, countDownLatch, n));
        }

        countDownLatch.await();
        System.out.println("数字打印完毕！");
        pool.shutdown();

    }
}
