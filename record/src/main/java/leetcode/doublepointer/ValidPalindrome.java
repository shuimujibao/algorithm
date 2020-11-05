package  leetcode.doublepointer;

/**
 * @auther: sunxiaoyu
 * @date: 2020-08-05 09:38
 * @description: 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "abcbfa";
        ValidPalindrome test = new ValidPalindrome();
        System.out.println("input:" + test.validPalindrome(input));
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char low = s.charAt(left);
            char high = s.charAt(right);
            if (low != high) {
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            char low = s.charAt(left);
            char high = s.charAt(right);
            if (low != high) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
