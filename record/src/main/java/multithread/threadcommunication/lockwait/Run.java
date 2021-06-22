package multithread.threadcommunication.lockwait;

/**
 * @author sunxiaoyu3
 * @description 测试
 * @createTime 2021/06/22 14:56:00
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(3000);
        service.signalAll_A();
    }
}
