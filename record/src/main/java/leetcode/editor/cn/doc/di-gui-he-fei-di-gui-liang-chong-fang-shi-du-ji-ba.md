
#### 1，递归解决
之前讲[356，青蛙跳台阶相关问题](https://mp.weixin.qq.com/s/hLpHLUfXsABzUNjuNflWzQ)的时候提到过斐波那契数列，代码比较简单
```
public int fib(int n) {
    if (n < 2)
        return n;
    return fib(n - 1) + fib(n - 2);
}
```
当n很大的时候可能会出现数字溢出，所以我们需要用结果对1000000007求余，但实际上可能还没有执行到最后一步就已经溢出了，所以我们需要对每一步的计算都要对1000000007求余，代码如下（**注意：下面代码不通过，会超时**）
```
int constant = 1000000007;

public int fib(int n) {
    if (n < 2)
        return n;
    int first = fib(n - 1) % constant;
    int second = fib(n - 2) % constant;
    return (first + second) % constant;
}
```
之前讲过斐波那契数列递归的时候会造成大量的重复计算，比如就计算fib(6)为例来看下
![image.png](https://pic.leetcode-cn.com/a6f819589ee5e50ec378f2c10835e9a510529bac44618444beb2202486062eee-image.png)

我们看到上面相同颜色的都是重复计算，当n越大，重复的越多，所以我们可以使用一个map把计算过的值存起来，每次计算的时候先看map中有没有，如果有就表示计算过，直接从map中取，如果没有就先计算，计算完之后再把结果存到map中。
```
int constant = 1000000007;

public int fib(int n) {
    return fib(n, new HashMap());
}

public int fib(int n, Map<Integer, Integer> map) {
    if (n < 2)
        return n;
    if (map.containsKey(n))
        return map.get(n);
    int first = fib(n - 1, map) % constant;
    map.put(n - 1, first);
    int second = fib(n - 2, map) % constant;
    map.put(n - 2, second);
    int res = (first + second) % constant;
    map.put(n, res);
    return res;
}
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/0b31e037787b0db3cafeb1291272f9320a15745c646409efffc817d80bfeaa3a-image.png)

#### 2，非递归解法
我们还可以把斐波那契递归改为非递归，代码很简单，可以看下
```
public int fib(int n) {
    int constant = 1000000007;
    int first = 0;
    int second = 1;
    while (n-- > 0) {
        int temp = first + second;
        first = second % constant;
        second = temp % constant;
    }
    return first;
}
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/92483e711066fabe381cf189478d91f491013b952e9054de5827292898d1935f-image.png)

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**
