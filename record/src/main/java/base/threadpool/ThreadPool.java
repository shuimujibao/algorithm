package base.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunxiaoyu3
 * @description 线程池
 * @createTime 2020/10/29 17:09:00
 */
public class ThreadPool {
    public static void main(String[] args) {
        int corePoolSize = 10;
        int maximumPoolSize = 100;
        long keepAliveTime = 1;
        TimeUnit unit = TimeUnit.SECONDS;
        LinkedBlockingDeque workQueue = new LinkedBlockingDeque();

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
}
