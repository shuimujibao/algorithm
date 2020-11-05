package  jvm;

/**
 * @author sunxiaoyu3
 * @description：创建线程导致的内存溢出
 * @createTime 2020/09/18 10:58:00
 * <p>
 * VM Args : Xss2M(栈容量越大，可创建的线程数越少)
 */
public class JavaVmStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(this::dontStop);
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }

}
