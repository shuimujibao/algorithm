package  leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther: sunxiaoyu
 * @date: 2020-08-06 19:54
 * @description: 按颜色进行排序
 */
public class SortColors {
    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 2, 1, 1, 1, 0, 7};
        sortColors(input);
    }

    /**
     * 给定一个整数数组，给定一个值K，这个值在原数组中一定存在，要求把数组中小于K的元素放到数组的左边，大于K的元素放到数组的右边，
     * 等于K的元素放到数组的中间，最终返回一个整数数组，其中只有两个值，分别是等于K的数组部分的左右两个下标值。
     * <p>
     * 例如，给定数组：[2, 3, 1, 9, 7, 6, 1, 4, 5]，给定一个值4，那么经过处理原数组可能得一种情况是：[2, 3, 1, 1, 4, 9, 7, 6, 5]，
     * 需要注意的是，小于4的部分不需要有序，大于4的部分也不需要有序，返回等于4部分的左右两个下标，即[4, 4]
     * <p>
     *
     * @param input
     */
    private static void sortColors(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //统计各个数字出现的频率
        for (int val : input) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[input.length + 1];

        for (Integer val : map.keySet()) {
            Integer num = map.get(val);
            if (bucket[num] == null) {
                bucket[num] = new ArrayList<>();
            }
            bucket[num].add(val);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == null) {
                continue;
            }
            for (int val : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    res.add(val);
                }
            }
        }


        System.out.println(res.toString());
    }
}
