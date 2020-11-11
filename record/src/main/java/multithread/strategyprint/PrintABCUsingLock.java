package multithread.strategyprint;

/**
 * @author sunxiaoyu3
 * @description 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * @createTime 2020/11/06 17:29:00
 */
public class PrintABCUsingLock implements Runnable {
    /**
     * 打印状态
     */
    private int states;
    /**
     * 打印次数
     */
    private int times;

    PrintABCUsingLock(int states, int times) {
        this.states = states;
        this.times = times;
    }

    @Override
    public void run() {


    }

    public static void main(String[] args) {

    }
}
