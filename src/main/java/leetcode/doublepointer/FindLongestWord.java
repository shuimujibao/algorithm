package leetcode.doublepointer;

import java.util.Arrays;
import java.util.List;

/**
 * @auther: sunxiaoyu
 * @date: 2020-08-05 19:23
 * @description: 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
 * 找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
 */
public class FindLongestWord {
    public static void main(String[] args) {
        String s = "abpcplea";
        s.charAt(1);
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord(s, d));
    }

    /**
     * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，
     * 我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
     *
     * @param s
     * @param d
     * @return
     */
    private static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();

            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }

            if (isSubstr(s, target)) {
                longestWord = target;
            }

        }
        return longestWord;
    }

    /**
     * 判断目标字符串 是否为源字符串的子串
     *
     * @param s
     * @param target
     * @return
     */
    private static boolean isSubstr(String s, String target) {
        //目标字符串的指针
        int i = 0;
        //源字符串对应的指针
        int j = 0;
        while (i < target.length() && j < s.length()) {
            if (target.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == target.length();
    }
}
