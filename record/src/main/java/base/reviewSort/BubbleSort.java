package base.reviewSort;

public class BubbleSort {
    /**
     * @description 平均时间复杂度O(n ^ 2) 最好情况O(n) 空间复杂度O(1) 稳定的排序
     * @author : itw_sunxy
     * @createtime : 2019/6/24 16:36
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    SwapUtil.swap(arr, j + 1, j);
                }
            }
        }
    }
}
