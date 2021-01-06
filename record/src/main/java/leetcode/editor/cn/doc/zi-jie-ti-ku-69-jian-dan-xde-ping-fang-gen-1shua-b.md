### 方法一：你懂我懂面试官懂唯独 offer 不懂的解法～ 先放C++代码，思路不存在。
```cpp
class Solution {
public:
    int mySqrt(int x) {
        return (int)sqrt(x);
    }
};
```
### 执行结果截图：
![image.png](https://pic.leetcode-cn.com/1604557805-XysKyi-image.png)
#
### 方法二：二分查找。先放C++代码，思路简单易懂。
```cpp
class Solution {
public:
    int mySqrt(int x) {
        if(x <= 1) {return x;}
        int l = 0, r = x, res = INT_MIN;
        while(l <= r) {
            long mid = (l + r) / 2; // 找出 l 和 r 的中点
            long temp = mid * mid;
            // int mid = l + (r - l) / 2; // 另一种表达，mid 可以写成 int
            // long temp = (long long)mid * mid;
            if(temp <= x) {
                res = mid;
                l = mid + 1;
            }
            else {r = mid - 1;}
        }
        return res;
    }
};
```
### 执行结果截图：
![image.png](https://pic.leetcode-cn.com/1604560247-lTvEun-image.png)
#
### 方法三：牛顿迭代法。稍后补充，刚做完算法课 HW3，又刷了四道题，着实有点累。
#
### Tracker
1. 1刷：2020/11/05


