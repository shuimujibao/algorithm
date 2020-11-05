package leetcode.reviewSort;

public class InsertSort {
    /**
     * @title 直接插入排序
     * @description 时间复杂度：O(n^2) 空间复杂度：O(1)
     * 插入排序所需要的时间取决于输入元素的初始顺序。例如对于一个很大且基本有序的数组排序
     * 将会比随机顺序的数组或者逆序的数组进行排序要快的多
     * @author : itw_sunxy
     * @createtime : 2019/6/24 10:57
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SwapUtil.swap(arr, j, j - 1);
                }
            }
        }
    }
}
