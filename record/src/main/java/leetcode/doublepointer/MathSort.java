package leetcode.doublepointer;

import java.util.Arrays;

/**
 * @author sunxiaoyu3
 * @description [1, 2, 3, 4, 5, 6] 奇数在前 偶数在后
 * @createTime 2021/06/21 18:17:00
 */
public class MathSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] % 2 != 0) {
                left++;
            }

            if (arr[right] % 2 == 0) {
                right--;
            }

            swap(arr, left, right);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
