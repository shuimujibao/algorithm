package interview.didi.second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/11/17 18:21:00
 */
public class Test2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Worker2(i));
        }
        executorService.shutdown();
    }
}
