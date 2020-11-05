package jvm;

/**
 * @author sunxiaoyu3
 * @description java栈溢出
 * @createTime 2020/09/18 10:40:00
 * <p>
 * VM Args : -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
