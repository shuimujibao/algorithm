package leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @auther: sunxiaoyu
 * @date: 2020-08-04 15:30
 * @description: 反转字符串中的元音字符
 */
public class ReverseVowels {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] result = new char[s.length()];
        while (left <= right) {
            char cleft = s.charAt(left);
            char cright = s.charAt(right);
            if (!vowels.contains(cleft)) {
                result[left++] = cleft;
            } else if (!vowels.contains(cright)) {
                result[right--] = cright;
            } else {
                result[left++] = cright;
                result[right--] = cleft;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        ReverseVowels test = new ReverseVowels();
        System.out.println(test.reverseVowels("leetcode"));
    }

}
