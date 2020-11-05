package  leetcode.greedyalgorithm;

/**
 * @author sunxiaoyu3
 * @description 一次股票交易包含买入和卖出，只进行一次交易，求最大收益
 * @createTime 2020/08/21 09:03:00
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {4, 3, 8, 3, 9};
        int maxValue = maxProfitTwo(prices);
        System.out.println("最大收益：" + maxValue);
    }

    /**
     * @return : int
     * @description: 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
     * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
     * @author: sunxiaoyu3
     * @date: 2020-08-21 09:04
     * @param: [arr]
     * @throws:
     */
    private static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxValue = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxValue = Math.max(maxValue, prices[i] - minPrice);
            }
        }

        return maxValue;
    }

    /**
     * @return : int
     * @description: <p>题目描述：可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易</p>
     * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，
     * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
     * @author: sunxiaoyu3
     * @date: 2020-08-21 10:07
     * @param: [prices]
     * @throws:
     */
    public static int maxProfitTwo(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
