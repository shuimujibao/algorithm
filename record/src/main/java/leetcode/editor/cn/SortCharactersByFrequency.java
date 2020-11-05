package  leetcode.editor.cn;

//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表 
// 👍 172 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        @SuppressWarnings("unchecked")
        public String frequencySort(String s) {
            char[] chars = s.toCharArray();

            //统计字符串出现的次数
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character target : chars) {
                map.put(target, map.getOrDefault(target, 0) + 1);
            }

            //构建桶 下标为当前字符出现的次数
            List<Character>[] bucket = new ArrayList[s.length() + 1];

            //将数据灌入桶中
            for (Character value : map.keySet()) {

                Integer index = map.get(value);

                if (bucket[index] == null) {
                    bucket[index] = new ArrayList<>();
                }
                bucket[index].add(value);
            }

            //按频次降序输出，所以倒着遍历
            StringBuilder sb = new StringBuilder();
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] == null) {
                    continue;
                }
                List<Character> characters = bucket[i];
                for (Character value : characters) {
                    for (int j = 0; j < i; j++) {
                        sb.append(value);
                    }
                }

            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}