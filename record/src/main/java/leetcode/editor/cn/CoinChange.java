package leetcode.editor.cn;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1348 👎 0

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {

            //目标值
            int[] f = new int[amount + 1];
            //多少种硬币
            int n = coins.length;
            //初始值
            f[0] = 0;

            //罗列f(X)
            for (int i = 1; i <= amount; i++) {
                //默认初值
                f[i] = Integer.MAX_VALUE;
                for (int coin : coins) {
                    //当前临界值，则避免了重复计算
                    if (i >= coin && f[i - coin] != Integer.MAX_VALUE) {
                        //求当前值，所用硬币最小数量
                        f[i] = Math.min(f[i - coin] + 1, f[i]);
                    }
                }
            }

            //当前值 不存在改组合
            if (f[amount] == Integer.MAX_VALUE) {
                f[amount] = -1;
            }

            return f[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}