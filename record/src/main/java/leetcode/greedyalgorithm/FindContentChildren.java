package  leetcode.greedyalgorithm;

import java.util.Arrays;

/**
 * @author sunxiaoyu3
 * @description 分配饼干
 * @createTime 2020/08/18 19:44:00
 */
public class FindContentChildren {

    public static void main(String[] args) {
        //孩子的满足度
        int[] grid = new int[]{1, 5, 7};
        //饼干的尺寸
        int[] size = new int[]{1, 2, 4};

        System.out.println(findContentChildren(grid, size));
    }

    /**
     * <p>贪心算法</p>
     * 局部最优 最后全局最优
     * <p>
     * 每次满足用最小的饼干 ，满足需求最小的孩子 即局部最优
     *
     * @param grid
     * @param size
     * @return
     */
    public static int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) {
            return 0;
        }
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0;
        int si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

}
