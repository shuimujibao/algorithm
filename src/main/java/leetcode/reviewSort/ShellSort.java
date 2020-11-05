package leetcode.reviewSort;

public class ShellSort {
    /**
     * @title 希尔排序
     * @description 非稳定排序, 时间复杂度O(nlog2n)
     * @author : itw_sunxy
     * @createtime : 2019/6/24 11:04
     */
    public static void sort(int[] arr) {
        int length = arr.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < arr.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        SwapUtil.swap(arr, j, j - h);
                    }
                }
            }
        }
    }
}
