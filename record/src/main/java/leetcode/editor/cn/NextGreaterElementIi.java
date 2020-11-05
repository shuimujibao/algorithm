package  leetcode.editor.cn;

//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 212 👎 0

import java.util.Stack;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            int[] ans = new int[nums.length];
            int x = -1;
            for(int i = 0;i<nums.length;i++){
                while(!stack1.empty() && nums[i] > stack1.peek()){
                    int y = stack2.pop();
                    stack1.pop();
                    ans[y] = nums[i];
                }
                if(stack1.empty())
                    x = i;
                stack1.push(nums[i]);
                stack2.push(i);
            }
            for (int i = 0;i<=x;i++){
                while(!stack1.empty() && nums[i] > stack1.peek()){
                    int y = stack2.pop();
                    stack1.pop();
                    ans[y] = nums[i];
                }

            }
            while(!stack2.empty()){
                int z = stack2.pop();
                ans[z] = -1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}