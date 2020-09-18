package util.data;

/**
 * @author sunxiaoyu3
 * @description 二维数组操作工具类
 * @createTime 2020/08/20 10:09:00
 */
public class TwoDimensionalArray {
    /**
     * 打印二维数组
     *
     * @param intervals
     */
    public static void printResult(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return;
        }
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
