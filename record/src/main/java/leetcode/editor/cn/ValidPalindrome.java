package leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 300 👎 0

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if(s == null || s.length() == 0) return true;
            int left = 0, right = s.length() - 1;
            while(left < right){
                //跳过不是字母和数字的字符
                while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                    left ++;
                }
                while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                    right --;
                }
                if(left < right){
                    if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                        return false;
                    }
                }
                ++left;
                --right;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}