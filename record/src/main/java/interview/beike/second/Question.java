package interview.beike.second;

/**
 * @author sunxiaoyu3
 * @description 三个线程同时有序的打印 1到20
 * @createTime 2020/11/06 13:43:00
 */
public class Question {
    public static void main(String[] args) {
        //打印最大值
        Integer maxMount = 20;
        //线程数量
        Integer threadMount = 3;

        for (int i = 0; i < threadMount; i++) {
            new Thread(new Worker(i, maxMount, threadMount)).start();
        }
    }
}
