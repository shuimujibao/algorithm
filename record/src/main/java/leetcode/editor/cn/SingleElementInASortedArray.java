package leetcode.editor.cn;

//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。 
// Related Topics 二分查找 
// 👍 181 👎 0
// n^0=n n^n=0，即任何数与0进行异或，为它本身，两个相同的数进行异或运算，会得到0。

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();

        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(2 ^ 3);
        //System.out.println(solution.singleNonDuplicate(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int target = nums[0];
            for (int i = 1; i < nums.length; i++) {
                System.out.println("target --->" + target);
                System.out.println("nums[" + i + "] ---> " + nums[i]);
                System.out.println(" target ^= nums[" + i + "] --->" + (target ^= nums[i]));
                System.out.println("*********************");
            }
            return target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}