package  leetcode.greedyalgorithm;

/**
 * @author sunxiaoyu3
 * @description 修改一个数成为非递减数组
 * @createTime 2020/08/24 09:14:00
 */
public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 1};
        boolean res = checkPossibility(nums);
        System.out.println("可以修改一个数成为非递减数组 ： " + res);
    }

    /**
     * @return : boolean
     * @description: 题目描述：判断一个数组是否能只修改一个数就成为非递减数组。
     * @author: sunxiaoyu3
     * @date: 2020-08-24 09:16
     * @param: [nums]
     */
    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }

            cnt++;

            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }

        return cnt <= 1;
    }
}
