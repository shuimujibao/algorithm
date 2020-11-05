package  leetcode.sort;

import java.util.Arrays;

/**
 * @author sunxiaoyu3
 * @description 最小的k个数
 * @createTime 2020/08/19 17:42:00
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
