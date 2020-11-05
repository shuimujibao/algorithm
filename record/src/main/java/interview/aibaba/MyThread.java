package  interview.aibaba;

/**
 * @author sunxiaoyu3
 * @description 线程改名
 * @createTime 2020/10/15 15:18:00
 */
public class MyThread extends Thread {
    private MyThread() {

    }


    private MyThread(String name) {
        super.setName(name);

    }

    @Override
    public void run() {
        System.out.println("线程-->" + currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("asadasa");
        myThread.start();
    }
}
