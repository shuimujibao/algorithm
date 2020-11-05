package leetcode.greedyalgorithm;

/**
 * @author sunxiaoyu3
 * @description 子数组最大的和
 * @createTime 2020/08/26 09:14:00
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(preSum, maxSum);

        }
        return maxSum;
    }
}
