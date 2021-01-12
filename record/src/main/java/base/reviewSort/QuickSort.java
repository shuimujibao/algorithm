package base.reviewSort;

public class QuickSort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * @description 平均时间复杂度O(nlogn) 最好情况O(logn) 最坏情况O(n^2) 空间时间复杂度O(1)
     * @author : itw_sunxy
     * @createtime : 2019/6/25 14:56
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        //以数组第一个数作为基准数
        int pivot = arr[low];
        //左边界索引
        int left = low;
        //右边界索引
        int right = high;
        while (left < right) {
            //从右边开始，依次递减,直到遇见比基准数小的数
            while (pivot <= arr[right] && left < right) {
                right--;
            }
            //从右边开始，依次递增，直到遇见一个比基准数大的数
            while (pivot >= arr[left] && left < right) {
                left++;
            }
            if (left < right) {
                SwapUtil.swap(arr, left, right);
            }
        }
        //当左右边界相撞的时候，将此事left与right指向的值与基准值交换
        SwapUtil.swap(arr, low, left);
        //至此形成以基准值pivot区分的两个数组，进行递归
        quickSort(arr, low, left - 1);
        quickSort(arr, right + 1, high);
    }
}
