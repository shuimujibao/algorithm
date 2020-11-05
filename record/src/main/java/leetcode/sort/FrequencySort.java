package leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther: 孙晓宇
 * @date: 2020-08-06 15:21
 * @description: 按照字符出现次数对字符串排序
 */
public class FrequencySort {
    public static void main(String[] args) {
        String input = "trrree";
        String outPut = frequencySort(input);
        System.out.println(outPut);
    }

    private static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //统计每个字符出现的次数
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //创建桶
        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for (Character c : map.keySet()) {
            //当前字符出现的次数
            Integer mount = map.get(c);
            if (bucket[mount] == null) {
                bucket[mount] = new ArrayList<>();
            }
            bucket[mount].add(c);
        }
        //排序后字符串
        StringBuilder res = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }

            List<Character> characters = bucket[i];

            for (Character c : characters) {
                for (int j = 0; j < i; j++) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
