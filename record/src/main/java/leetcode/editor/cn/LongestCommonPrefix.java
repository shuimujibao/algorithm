package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1896 👎 0

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

//            // 临界值 直接返回
//            if (strs == null) {
//                return null;
//            }
//
//            if (strs.length == 1) {
//                return strs[0];
//            }
//
//            // 最长公共前缀
//            StringBuilder sb = new StringBuilder();
//
//            // 比较最大次数
//            int compareNum = strs.length - 1;
//
//            // 获取当前字符串数组最短的字符串长度
//            int minStringLength;
//            String minString = "";
//            for (String str : strs) {
//                if (str.length() < minString.length()) {
//                    minString = str;
//                }
//            }
//            minStringLength = minString.length();
//
//            //待比较字符的索引位置
//            int index = 0;
//
//            while (index <= minStringLength) {
//
//                // 两两比较，需要比较（strs.length - 1）次
//                for (int i = 0; i < strs.length; i++) {
//                    int temp = compareNum;
//                    // 即可进入当前判断（strs.length - 1）次，则当前位置字符串一致
//                    if (strs[i].charAt(index) == strs[i + 1].charAt(index)) {
//                        temp--;
//                        if (temp == 0) {
//                            sb.append(strs[i].charAt(0));
//                        }
//                    }
//                }
//                index++;
//            }
//
//            return sb.toString();

            if (strs.length == 0)
                return "";

            String ans = strs[0];

            for (int i = 1; i < strs.length; i++) {

                int j = 0;

                for (; j < ans.length() && j < strs[i].length(); j++) {
                    if (ans.charAt(j) != strs[i].charAt(j))
                        break;
                }

                ans = ans.substring(0, j);

                if (ans.equals(""))

                    return ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}