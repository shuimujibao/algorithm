package multithread.juc;

import java.util.concurrent.Semaphore;

/**
 * @author sunxiaoyu3
 * @description 假设某机场的海关通道共有3 个窗口1 一批需要出关的人排成长队，每个
 * 人都是一个结程。当3 个窗口中的任意一个出现空闲时，工作人员指示队列中第一个
 * 人出队到该空闲窗口接受查验。
 * @createTime 2020/10/26 19:40:00
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        int number = 10;
        for (int i = 0; i < number; i++) {
            new Check(semaphore, i).start();
        }
    }

    private static class Check extends Thread {
        Semaphore semaphore;
        Integer number;

        Check(Semaphore semaphore, Integer number) {
            this.semaphore = semaphore;
            this.number = number;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                if (number % 2 == 0) {
                    System.out.println("身份异常->number:" + number + "threadId:" + Thread.currentThread().getName());
                }
                sleep(5000);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                semaphore.release();
                System.out.println("身份正常->number:" + number + "threadId:" + Thread.currentThread().getName());
            }
        }
    }
}
