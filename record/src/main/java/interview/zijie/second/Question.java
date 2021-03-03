package interview.zijie.second;

import leetcode.editor.cn.TreeNode;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunxiaoyu3
 * @description 算法
 * @createTime 2021/01/25 10:10:00
 */
public class Question {

    /**
     * 模拟10000个请求的并发
     *
     * @param args 主函数
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Worker(cyclicBarrier));
        }
        executorService.shutdown();
    }


    /**
     * 爬楼梯问题
     * 一次只能走一步或者两步 求有多少种走法
     *
     * @param n 总数
     * @return int 方式数量
     */
    public int climbStair(int n) {
        if (n < -1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStair(n - 1) + climbStair(n - 2);
    }

    /**
     * 树的广度优先遍历
     *
     * @param root 树
     */
    public void BFS(TreeNode root) {

    }


}
