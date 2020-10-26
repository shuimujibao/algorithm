package juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @author sunxiaoyu3
 * @description 还有其他同步方式， 如CyclicBarrier 是基于同步到达某个点的信号量触发机制。
 * Cyc l icBarrier 从命名上即可知道它是一个可以循环使用（ Cycl ic ）的屏障式（ Barrier)
 * 多线程协作方式。采用这种方式进行刚才的安检服务， 就是3 个人同时进去，只有3
 * 个人都完成安检，才会放下一批进来。这是一种非常低效的安检方式。但在某种场景
 * 下就是非常正确的方式，假设在机场排队打车时，现场工作人员统一指挥，每次放3
 * 辆车进来，坐满后开走， 再放下一批车和人进来。通过Cycl icBarrier 的reset（） 来释放
 * 线程资源。
 * @createTime 2020/10/26 20:05:00
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        int number = 10;
        for (int i = 0; i < number; i++) {
            new CyclicBarrierTest.Check(cyclicBarrier, i).start();
        }
    }

    private static class Check extends Thread {
        CyclicBarrier cyclicBarrier;
        Integer number;

        Check(CyclicBarrier cyclicBarrier, Integer number) {
            this.cyclicBarrier = cyclicBarrier;
            this.number = number;
        }

        @Override
        public void run() {
            try {
                if (number % 2 == 0) {
                    System.out.println("身份异常->number:" + number + "threadId:" + Thread.currentThread().getName());
                } else {
                    System.out.println("身份正常->number:" + number + "threadId:" + Thread.currentThread().getName());
                }
                sleep(5000);
                cyclicBarrier.await();
                System.out.println("身份全部检查完成.");
            } catch (Exception e) {
                System.out.println(e);
            } finally {

            }
        }
    }
}
