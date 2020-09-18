package leetcode.sort;

import util.data.Swap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author sunxiaoyu
 * @date: 2020-08-06 09:30
 * @description: 题目描述：找到倒数第 k 个的元素
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int res = findKthLargest3(arr, k);
        System.out.println(res);
    }

    /**
     * 排序
     *
     * @param arr
     * @param k
     * @return
     */
    private static int findKthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    /**
     * 堆
     *
     * @param arr
     * @param k
     * @return
     */
    private static int findKthLargest1(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * 快速选择
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            Swap.handle(a, i, j);
        }
        Swap.handle(a, l, j);
        return j;
    }
}
