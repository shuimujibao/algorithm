package leetcode.editor.cn;

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 121 👎 0

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        solution.reverseVowels("hello");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            HashSet<Character> vowels = new HashSet<>(
                    Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            int low = 0;
            int high = s.length() - 1;
            char[] chars = s.toCharArray();
            while (low < high) {
                char left = chars[low];
                char right = chars[high];
                if (vowels.contains(left) && vowels.contains(right)) {
                    chars[high] = left;
                    chars[low] = right;
                    low++;
                    high--;
                } else if (vowels.contains(left) && !vowels.contains(right)) {
                    high--;
                } else {
                    low++;
                }
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}