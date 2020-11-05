package util.data;

/**
 * @author sunxiaoyu
 * @date: 2020-08-06 10:24
 * @description: 数据交换
 */
public class Swap {
    public static void handle(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
