
### 1，递归
这题最容易想到的就是递归，啥叫“递归”，也就是下面这张图
![image.png](https://pic.leetcode-cn.com/61776df1e376ee9593d0d5a3c84f57158b1c7562a0a8f802b6f0df37ef5108b5-image.png)
开个玩笑，我们画个图来看下
![image.png](https://pic.leetcode-cn.com/f26ceb47110a4d431260a6af03c127027d9e1bdfd3980c553376734ca29fe545-image.png)
原理很简单，代码如下
```
 public int maxDepth(TreeNode root) {
        return root==null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
```
运行时间
![image.png](https://pic.leetcode-cn.com/e4b00803e2798c9741f13eac1690081a4f76cbf89add48340c61956f9b1fae9a-image.png)

### 2，BFS
BFS的实现原理就是一层层遍历，统计一下总共有多少层，我们来画个图分析一下。
![image.png](https://pic.leetcode-cn.com/4d908dab4fe456418f3c06a124c4a0391c67f19780bfafc24d33878541faa665-image.png)
代码如下
```
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }
```
我们再来看一下运行时间，显然效率不是很高
![image.png](https://pic.leetcode-cn.com/eafb8fe8836a8beb08cc37fe81c7e0a546c4270f3ad5e7a7d23d289c982afa52-image.png)

### 3，DFS
我们可以使用两个栈，一个记录节点的stack栈，一个记录节点所在层数的level栈，stack中每个节点在level中都会有一个对应的值，并且他们是同时出栈，同时入栈
```
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //stack记录的是节点，而level中的元素和stack中的元素
        //是同时入栈同时出栈，并且level记录的是节点在第几层
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            //stack中的元素和level中的元素同时出栈
            TreeNode node = stack.pop();
            int temp = level.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                //同时入栈
                stack.push(node.left);
                level.push(temp + 1);
            }
            if (node.right != null) {
                //同时入栈
                stack.push(node.right);
                level.push(temp + 1);
            }
        }
        return max;
    }
```
运行结果
![image.png](https://pic.leetcode-cn.com/9bb0ac5ae41bcf072e283a92ba0b23033126a510e989767d68ef9a73e7564f73-image.png)

如果觉得有用就给个赞吧。查看更多算法题，还可以关注下面微信公众号
公众号：**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**

[367，二叉树的最大深度](https://mp.weixin.qq.com/s/aHSqZaylNQiEP6BIqKSd3g)
[403，验证二叉搜索树](https://mp.weixin.qq.com/s/B9zmMQDCSWanjHCCwUSAuA)
[401，删除二叉搜索树中的节点](https://mp.weixin.qq.com/s/tI0emo7riEOb58y7phqiKA)
[400，二叉树的锯齿形层次遍历](https://mp.weixin.qq.com/s/X18PZ6PTV5u_xLRr5_3Taw)
[399，从前序与中序遍历序列构造二叉树](https://mp.weixin.qq.com/s/Msx35Cg70NyKALSBiydRug)
[388，先序遍历构造二叉树](https://mp.weixin.qq.com/s/D1W3DKFFy1Bw9yuQdMaJ-w)
[387，二叉树中的最大路径和](https://mp.weixin.qq.com/s/EY3wOMmlVkX4Lzo6mfzFoQ)
[375，在每个树行中找最大值](https://mp.weixin.qq.com/s/XRZHt9rd1rVNHZRu5cErnQ)
[374，二叉树的最小深度](https://mp.weixin.qq.com/s/WJj7rNR8I2gT3mKllP--VQ)
[373，数据结构-6,树](https://mp.weixin.qq.com/s/mBXfpH4nuIltyHm72zLryw)
[372，二叉树的最近公共祖先](https://mp.weixin.qq.com/s/V73MWneaud5A97j_Ltxnmw)
