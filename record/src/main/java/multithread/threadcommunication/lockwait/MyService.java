package multithread.threadcommunication.lockwait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2021/06/22 14:50:00
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    //使用多个Condition实现通知部分线程
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();


    public void awaitA() {
        lock.lock();
        try {
            System.out.println("begin awaitA时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        lock.lock();
        try {
            System.out.println("begin awaitB时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("  signalAll_A时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("  signalAll_B时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
