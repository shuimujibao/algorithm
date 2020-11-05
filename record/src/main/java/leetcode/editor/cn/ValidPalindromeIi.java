package  leetcode.editor.cn;

//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 279 👎 0

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int low = 0;
            int high = chars.length - 1;
            while (low < high) {
                int left = chars[low];
                int right = chars[high];
                if (left != right) {
                    return isPalindrome(chars, low + 1, high) || isPalindrome(chars, low, high - 1);
                }
                low++;
                high--;
            }
            return true;
        }

        private boolean isPalindrome(char[] chars, int low, int high) {
            while (low < high) {
                int left = chars[low];
                int right = chars[high];
                if (left != right) {
                    return false;
                }
                low++;
                high--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}