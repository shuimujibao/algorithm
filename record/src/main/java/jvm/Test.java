package jvm;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2021/08/11 18:01:00
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        new Thread(test::eat).start();

        Test test2 = new Test();

        new Thread(test::walk).start();
    }

    public synchronized void eat() {
        try {
            Thread.sleep(10000);
            System.out.println("eat");
        } catch (Exception e) {

        }

    }

    public synchronized void walk() {
        try {
            System.out.println("walk");
        } catch (Exception e) {

        }
    }
}
