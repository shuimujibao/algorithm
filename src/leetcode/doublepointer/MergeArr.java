package leetcode.doublepointer;

import java.util.Arrays;

/**
 * @author sunxiaoyu
 * @date: 2020-08-05 15:56
 * @description:题目描述：把归并结果存到第一个数组上。
 */
public class MergeArr {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 4;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }
}
