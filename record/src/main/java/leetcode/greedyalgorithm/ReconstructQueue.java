package  leetcode.greedyalgorithm;

import util.data.TwoDimensionalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunxiaoyu3
 * @description 根据身高和序号重组队列
 * @createTime 2020/08/20 09:58:00
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        TwoDimensionalArray.printResult(people);
        int[][] res = reconstructQueue(people);
        TwoDimensionalArray.printResult(res);

    }

    /**
     * @return : int[][]
     * @description: <p>题目描述：一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。</p>
     * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
     * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
     * @author: sunxiaoyu3
     * @date: 2020-08-20 10:00
     * @param: [people]
     */
    private static int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, Comparator.comparingInt(o -> o[0]));
//        TwoDimensionalArray.printResult(people);
//        Arrays.sort(people, Comparator.comparingInt(o -> o[1]));


//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });
//        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
//        TwoDimensionalArray.printResult(people);

        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

}
