package leetcode.doublepointer;

import java.util.Arrays;

/**
 * @author sunxiaoyu
 * @date: 2020-06-21 16:05
 * @description: 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                if (temp == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }

        }
        return res;
    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumNum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[2];
        //左指针
        int left = 0;
        //右指针
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            } else if (temp < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSumNum(arr, 9)));
    }
}
