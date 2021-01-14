
### 1，动态规划解决

这题是让求**最大的连续子序和**，如果不是连续的非常简单，只需要把所有的正数相加即可。但这里说的是连续的，中间可能掺杂负数，如果求出一个最大子序和在加上负数肯定要比原来小了。解这题最简单的一种方式就是使用动态规划。

<br>

我们先来了解一下动态规划的几个步骤

**1，确定状态**

**2，找到转移公式**

**3，确定初始条件以及边界条件**

**4，计算结果。**

<br>

最后一个不用看，只看前3个就行，因为前3个一旦确定，最后一个结果也就出来了。我们试着找一下

<br>

1，定义```dp[i]```表示数组中前```i+1```（**注意这里的i是从0开始的**）个元素构成的连续子数组的最大和。
<br>


2，如果要计算前```i+1```个元素构成的连续子数组的最大和，也就是计算```dp[i]```，只需要判断```dp[i-1]```是大于0还是小于0。如果```dp[i-1]```大于0，就继续累加，```dp[i]=dp[i-1]+num[i]```。如果```dp[i-1]```小于0，我们直接把前面的舍弃，也就是说重新开始计算，否则会越加越小的，直接让```dp[i]=num[i]```。所以转移公式如下

```dp[i]=num[i]+max(dp[i-1],0);```

<br>

3，边界条件判断，当i等于0的时候，也就是前1个元素，他能构成的最大和也就是他自己，所以

```dp[0]=num[0];```

<br>

找到了上面的转移公式，代码就简单多了，来看下

```
public int maxSubArray(int[] num) {
    int length = num.length;
    int[] dp = new int[length];
    //边界条件
    dp[0] = num[0];
    int max = dp[0];
    for (int i = 1; i < length; i++) {
        //转移公式
        dp[i] = Math.max(dp[i - 1], 0) + num[i];
        //记录最大值
        max = Math.max(max, dp[i]);
    }
    return max;
}
```


<br>

### 2，代码优化

仔细看下上面的代码会发现，我们申请了一个长度为length的数组，但在转移公式计算的时候，每次计算当前值的时候只会用到前面的那个值，再往前面就用不到了，这样实际上是造成了空间的浪费。这里不需要一个数组，只需要一个临时变量即可，看下代码

```
public int maxSubArray(int[] num) {
    int length = num.length;
    int cur = num[0];
    int max = cur;
    for (int i = 1; i < length; i++) {
        cur = Math.max(cur, 0) + num[i];
        //记录最大值
        max = Math.max(max, cur);
    }
    return max;
}
```

再来看下运行结果

![image.png](https://pic.leetcode-cn.com/1610416678-jFPlJD-image.png)



<br>

#### 如果觉得有用就给个赞吧，还可以关注我的[LeetCode主页](https://leetcode-cn.com/u/sdwwld/)查看更多的详细题解











