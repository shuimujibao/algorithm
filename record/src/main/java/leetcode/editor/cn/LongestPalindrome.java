package leetcode.editor.cn;

//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 贪心 哈希表 字符串 
// 👍 302 👎 0

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            //Ascii码表0-128
            int[] arr = new int[128];
            //出现的字符次数+1
            for (char a : s.toCharArray()) {
                arr[a]++;
            }
            int num = 0;
            for (int i : arr) {
                //主要是来看i是否出现偶数次   出现偶数次就+偶数
                num += i / 2 * 2;
                //但在发现了第一个出现次数为奇数的字符后，我们将 ans 增加 1，这样 ans 变为奇数，在后面发现其它出现奇数次的字符时，我们就不改变 ans 的值了。
                if (i % 2 == 1 && num % 2 == 0) {
                    num++;
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}