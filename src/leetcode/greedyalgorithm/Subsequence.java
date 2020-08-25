package leetcode.greedyalgorithm;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/08/21 14:26:00
 */
public class Subsequence {
    public static void main(String[] args) {
        String s = "ac";
        String t = "abcde";
        System.out.println("是否为其子序列：" + isSubsequence(s, t));
    }

    /**
     * @return : boolean
     * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * @author: sunxiaoyu3
     * @date: 2020-08-21 14:27
     * @param: [s, t]
     * @throws:
     */
    public static boolean isSubsequence(String s, String t) {
        int low = 0;
        int high = 0;
        while (low < s.length() && high < t.length()) {
            if (t.charAt(high) == s.charAt(low)) {
                low++;
            }
            high++;
        }
        return low == s.length();
    }
}
