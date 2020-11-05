package  leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther: 孙晓宇
 * @date: 2020-08-06 10:29
 * @description: 出现频率最多的 k 个元素
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(arr, k));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer val : nums) {
            //统计每个数字出现的次数 key为该数字 value为出现的次数
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        //创建容量为数组长度一样大的桶(极端情况数组中所有的数字都相同)
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        //遍历出现各个数字
        for (Integer num : map.keySet()) {
            //获取当前数字，出现的次数,作为桶的角标，出现相同次数数字，放在同一个桶中
            Integer mount = map.get(num);
            if (bucket[mount] == null) {
                bucket[mount] = new ArrayList<>();
            }
            bucket[mount].add(num);
        }

        //获取出现频率最高的k个元素
        List<Integer> topK = new ArrayList<>();

        //遍历桶 --> 从最高频率向下遍历
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] == null) {
                //跳过本次循环，说明数组中不存在当前频率的数字
                continue;
            }

            if (bucket[i].size() <= k - topK.size()) {
                topK.addAll(bucket[i]);
            } else {
                topK.addAll(bucket[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }
}
