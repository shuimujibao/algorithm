萌新刚开始刷题，这是第五道题。因为有#496.下一个更大元素Ⅰ，第一道题的单调栈的思路，所以没有看答案也能很快做出来。其实大佬几句话就能表达完意思，就是在单调栈基础上算第二遍算到栈底元素结束。我还是以我自己这个菜鸡作为读者的标准，写一个碎碎念的版本吧
### 题解
#### 延续上一题的分析
这题和**496**的区别在于变成了一个概念上的循环数组，你要找到的是每个数的解，因此我们就不用496中的哈希表来快速查询了，直接用一个等长数组来存储我们的每个解。此外，第一道题中，最后栈中的元素都没有下一个最大元素，因此可以通通出栈赋-1，循环数组意味着这些数的解可能在前面。

那么我们先不管循环数组，沿用第一题的方法把整个数组过一遍进行求解。

#### 新的问题
> 我遇到的第一个问题，不用哈希表查键值，怎么输出答案呢？

我的方法是再加一个栈2，和栈1同步进行入栈出栈操作，栈1存nums数组的单个值，栈2对应的数组下标。所以每当出栈时，就可以把栈1中出栈的值保存到ans数组中栈2出栈的值下标中，保存解的步骤就完成了。

> 第二个问题，循环数组，第一轮过后剩下的怎么继续求解呢？

~~这里我们直接再算一遍，搞定~~
因为处理完第一轮，剩下的依然是单调栈，也就是栈底的元素最大，向上依次减少，我们设栈底元素在nums数组中的下标为x，因此栈中这些元素的解只可能在下标0~x（包括x本身）中，（此外，栈底元素x必定无解），那么我们只需要在第一轮运算中时刻记录栈底元素的下角标即可，栈底元素就是在栈空的情况下push进的第一个元素。所以在每次push操作前加一个if判断，如果栈空，则把角标的值记录下来。
得到了x值，相当于把0-x的值接到nums数组的末尾，再来一次求解即可，第二轮和上一轮不同的情况是，后来接上去的0-x不需要求解，因此入栈的操作就省去了。

两轮完成后，剩下的元素必定无解，因为是循环数组，所以剩下的只可能是数组里值最大的元素，但是题目没有说元素的值不能重复，不排除有多个值，这里让所有元素出栈，对应栈2下标的元素解为-1.

![image.png](https://pic.leetcode-cn.com/1604068520-VCGnsD-image.png)

### 代码
```Java
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
```