package  leetcode.greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sunxiaoyu3
 * @description 题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，
 * 使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
 * @createTime 2020/08/19 16:23:00
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int res = findMinArrowShots(points);

        System.out.println("投飞镖次数" + res);

    }

    /**
     * @return : int
     * @description: 求重叠区间的数量
     * @author: sunxiaoyu3
     * @date: 2020-08-19 16:25
     * @param: [points]
     * @throws:
     */
    private static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int end = points[0][1];
        int cnt = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }

            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
