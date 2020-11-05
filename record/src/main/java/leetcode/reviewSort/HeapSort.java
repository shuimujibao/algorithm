package leetcode.reviewSort;

public class HeapSort {
    public static void sort(int[] arr) {
        //创建大根堆
        for (int i = arr.length - 1; i > 0; i--) {
            max_heapify(arr, i);
            //将堆顶元素与Kn交换
            SwapUtil.swap(arr, 0, i);
        }
    }

    /**
     * @description 将数组堆化
     * 时间复杂度O(nlogn) 空间复杂度O(1) 不稳当排序
     * @author : itw_sunxy
     * @createtime : 2019/6/24 14:49
     */
    private static void max_heapify(int[] arr, int i) {
        for (int j = i; j > 0; j--) {
            int parent = (j - 1) / 2;
            if (arr[j] > arr[parent]) {
                SwapUtil.swap(arr, j, parent);
            }
        }
    }
}
