
之前专门写过这道题的解法，也可以在这里看下
### [389，两个超级大数相加](https://mp.weixin.qq.com/s/fbCw49WLo0FImAIFl4pinQ)

下面写了几种解法，其实原理都是一样，没什么改变，来看一下。
#### 1,StringBuilder尾部插入
我们先来看一下用两个很短的字符串"12367"+"89"为例画个图来看下是怎么计算的
![image.png](https://pic.leetcode-cn.com/8dacfeae2ce943454cc1df78b60a7fc8fe62173a9e20b22d72f81d945c8672f0-image.png)
它相当于两个字符串从最右边开始相加，比如我们要计算num1字符串的最右边的那个数字和num2字符串最右边的那个字符相加
```
int i = num1.length() - 1, j = num2.length() - 1;
int x = num1.charAt(i) - '0';
int y = num2.charAt(j) - '0';
int sum = x + y;
```
把计算的结果放到一个新的字符串后面，但字符串每一位只能保存一位数字，而我们相加的结果sum可能是个两位数，所以这里我们只取他的个位数，十位数要往前进一位。比如我们要计算num1和num2的倒数第二位
```
int x = num1.charAt(i - 1) - '0';
int y = num2.charAt(j - 1) - '0';
int sum = x + y + carry;
```
carry就是上一步相加结果的进位，上一步如果进位了就是1，如果没进位就是0。搞懂了上面的相加过程，剩下的就是一些边界条件的判断。最后不要忘了对字符串进行反转，因为我们相加的时候是从num1和num2的尾部开始加的，下面我们来看下完整代码
```

public String addStrings(String num1, String num2) {
    StringBuilder s = new StringBuilder();
    int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
    while (i >= 0 || j >= 0 || carry != 0) {
        int x = i < 0 ? 0 : num1.charAt(i--) - '0';
        int y = j < 0 ? 0 : num2.charAt(j--) - '0';
        int sum = x + y + carry;
        s.append(sum % 10);//添加到字符串尾部
        carry = sum / 10;
    }
    return s.reverse().toString();//对字符串反转
}
```
我们来看下一下运行结果
![image.png](https://pic.leetcode-cn.com/d0edc9f1e3c0b9f91c63a0c5f49df4982df672175ffd6c19837f642c051e031f-image.png)
我们看到运行效率并不是很高，我们可以直接把字符串先转为字符数组，**运行时间瞬间击败了99.89%的用户**
```
    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1Char[i--] - '0';
            int y = j < 0 ? 0 : num2Char[j--] - '0';
            int sum = x + y + carry;
            s.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        return s.reverse().toString();//对字符串反转
    }
```
![image.png](https://pic.leetcode-cn.com/e1e6909e39634e552524d93f7e4aa6eeee884f84fe7e1d81432849f021ef716b-image.png)


#### 2,StringBuilder头部插入
上面是插入到字符串的尾部，最后再反转。实际上我们在计算的时候还可以先插入到字符串的头部，最后直接返回即可，不需要再反转了，代码和上面差不多，我们来看下
```
public String addStrings(String num1, String num2) {
    StringBuilder s = new StringBuilder();
    int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
    while (i >= 0 || j >= 0 || carry != 0) {
        int x = i < 0 ? 0 : num1.charAt(i--) - '0';
        int y = j < 0 ? 0 : num2.charAt(j--) - '0';
        int sum = x + y + carry;
        s.insert(0, sum % 10);//插入到s字符串的第一个位置
        carry = sum / 10;
    }
    return s.toString();
}
```
再来看一下运行结果，我们看到头部插入比尾部插入效率差很多，因为头部插入需要不停的修改字符的位置。
![image.png](https://pic.leetcode-cn.com/073cf641e45f071cbaaab8437bc075eb3a7f9a42d78367812db7370e89e34852-image.png)

#### 3,使用栈来解决
我们还可以先把相加的结果放到一个栈中，最后再一个个出栈。
```
public String addStrings(String num1, String num2) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
    while (i >= 0 || j >= 0 || carry != 0) {
        carry += i >= 0 ? num1.charAt(i--) - '0' : 0;
        carry += j >= 0 ? num2.charAt(j--) - '0' : 0;
        stack.push(carry % 10);
        carry = carry / 10;
    }
    while (!stack.isEmpty())
        sb.append(stack.pop());
    return sb.toString();
}
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/20d4494fc1eff047d208685f16ca7790ad802d1af51766de926621662c9c649f-image.png)

#### 4,递归的方式解决
```

public String addStrings(String num1, String num2) {
    return addBinaryHelper(num1, num1.length() - 1, num2, num2.length() - 1, 0);
}

public String addBinaryHelper(String num1, int indexA, String num2, int indexB, int carry) {
    if (indexA < 0 && indexB < 0 && carry == 0)
        return "";
    carry += indexA < 0 ? 0 : num1.charAt(indexA--) - '0';
    carry += indexB < 0 ? 0 : num2.charAt(indexB--) - '0';
    int digit = carry % 10;
    carry = carry / 10;
    String res = addBinaryHelper(num1, indexA, num2, indexB, carry);
    return res + digit;
}
```
看一下运行结果，这种效率更差
![image.png](https://pic.leetcode-cn.com/567923efd01609d0188abab6e1d8e5d98cf3d0298d38404847891d0f9b9d2812-image.png)

![image.png](https://pic.leetcode-cn.com/d56a80459005b444404d2ad6fbaabdabecd2b9ed3cb2cf432e570c315ae2fcf7-image.png)
##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”