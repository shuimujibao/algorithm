### 解题思路
本题解 采用了 **动态规划** 的思想

### 运行结果
![image.png](https://pic.leetcode-cn.com/1606810299-LxltJC-image.png)

### 代码

```java
class Solution {
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1_000_000_007;
        }
        return dp[n];
    }
}
```
打卡131天，加油！！！
今天是 模块化刷算法 的第一天，敬请关注本人 模块化题解-动态规划专题 博文：
[《【算法精研】动态规划 总集篇》](https://www.cnblogs.com/codderYouzg/p/14067635.html)