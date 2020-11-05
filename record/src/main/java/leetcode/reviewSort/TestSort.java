package  leetcode.reviewSort;

import java.util.Arrays;


public class TestSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 2, 1, 8, 6, 5};
        System.out.println("排序前：" + Arrays.toString(arr));
        MergeSort.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));

    }
}
