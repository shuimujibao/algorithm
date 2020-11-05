package  leetcode.editor.cn;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 553 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        solution.topKFrequent(nums, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        @SuppressWarnings("unchecked")
        public int[] topKFrequent(int[] nums, int k) {

            //统计每个数字出现的次数
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int value : nums) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            //每个数字出现的次数为桶的下标
            List<Integer>[] buckets = new ArrayList[nums.length + 1];

            //将数字灌入桶中
            for (int value : map.keySet()) {
                Integer mount = map.get(value);
                if (buckets[mount] == null) {
                    buckets[mount] = new ArrayList<>();
                }
                buckets[mount].add(value);
            }

            //出现频率topK数据集合
            List<Integer> topK = new ArrayList<>();

            //出现频率topK所以倒着遍历
            for (int i = buckets.length - 1; i > 0 && topK.size() < k; i--) {

                if (buckets[i] == null) {
                    continue;
                }

                if (buckets[i].size() <= (k - topK.size())) {
                    topK.addAll(buckets[i]);
                } else {
                    topK.addAll(buckets[i].subList(0, k - topK.size()));
                }
            }

            int[] res = new int[k];

            for (int i = 0; i < topK.size(); i++) {
                res[i] = topK.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}