package  leetcode.greedyalgorithm;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sunxiaoyu3
 * @description 计算让一组区间不重叠所需要移除的区间个数。
 * @createTime 2020/08/19 09:58:00
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {3, 4}, {7, 10}, {5, 9}};
        printResult(intervals);

        int res = eraseOverlapIntervals(intervals);
        System.out.println("移除的区间个数 : " + res);
    }

    /**
     * @return : int
     * @description: 需要移除区间个数 = 获取区间总个数 - 不重叠区间个数
     * <p>按照区间末尾最小值排序</p>
     * @author: sunxiaoyu3
     * @date: 2020-08-19 15:44
     * @param: [intervals]
     * @throws:
     */
    private static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        //区间末尾排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        //输出排序后的二维数组
        printResult(intervals);

        //需要移除的区间数量
        int cnt = 1;

        //第一个区间末尾值
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }

    private static void printResult(int[][] intervals) {
        System.out.println("**********************");
        for (int i = 0; i < intervals.length; i++) {//s.length表示行数
            System.out.print("[");
            for (int j = 0; j < intervals[i].length; j++) {//s[i].length表示列数
                System.out.print(intervals[i][j] + " ");
            }
            System.out.print("]");
            System.out.println("\t");
        }
    }
}
