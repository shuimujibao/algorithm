package multithread.strategyprint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunxiaoyu3
 * @description 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * @createTime 2020/11/06 17:29:00
 * <p>
 * 思路
 * +-------------------------------+
 * 1  ---> A   1%3=1   线程一
 * 2  ---> B   2%3=2         线程二
 * 3  ---> C   3%3=0               线程三
 * 4  ---> A   4%3=1   线程一
 * 5  ---> B   5%3=2         线程二
 * 6  ---> C   6%3=0               线程三
 * 7  ---> A   7%3=1   线程一
 * +-------------------------------+
 * <p>
 * 一号线程只打印A
 * 二号线程只打印B
 * 三号线程只打印C
 */
public class PrintABCUsingLock implements Runnable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int n = 10;
        String name;
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                name = "A";
            } else if (i == 2) {
                name = "B";
            } else {
                name = "C";
            }
            executorService.submit(new PrintABCUsingLock(name, i, n));
        }

        executorService.shutdown();
    }

    /**
     * 当前输出字符
     */
    private String name;

    /**
     * 当前线程号
     */
    private int threadId;

    /**
     * 打印次数
     */
    private int n;

    /**
     * 保证同一时刻只有一个线程获取输出资源
     */
    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private PrintABCUsingLock(String name, int threadId, int n) {
        this.name = name;
        this.threadId = threadId;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; ) {
            try {
                lock.lock();
                if (i % 3 == threadId) {
                    System.out.println("当前第" + i + "次输出--->" + "线程ID为--->" + threadId + "输出字符--->" + name);
                    condition.await();
                }
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                i++;
                lock.unlock();
            }
        }
    }
}
