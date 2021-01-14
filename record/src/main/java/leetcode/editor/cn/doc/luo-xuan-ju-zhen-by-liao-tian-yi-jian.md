##### 从外部向内部逐层遍历打印矩阵，最外面一圈打印完，里面仍然是一个矩阵

统计矩阵的层数，每一层最多会占据两行或者两列，最少会占据一行或者一列元素，只有一层或者一列，也算一层，分层如下图：

![螺旋矩阵.JPG](https://pic.leetcode-cn.com/6936cb00971072cf40e96462e782aa47563fa4b24831d72749699c8fd9af7255-%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5.JPG)

```
int m = matrix.length;
int n = matrix[0].length;
int count = (Math.min(m, n)+1)/2;
```

##### 开始打印第 `i` 层的矩阵元素

![螺旋矩阵2.JPG](https://pic.leetcode-cn.com/a2e0022203893856ec9baa3fa3db6b0b1e6e49b4f3955e086f437852ec88a31d-%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B52.JPG)


##### 如上图所示，再打印第i层的矩阵时，要经历4个循环：

第 1 个：从左向右
``` 
for (int j = i; j < n-i; j++) {
    list.add(matrix[i][j]);
} 
```
第 2 个：从上往下
```
for (int j = i+1; j < m-i; j++) {
    list.add(matrix[j][(n-1)-i]);
}
```
第 3 个：从右往左，如果这一层只有1行，那么第一个循环已经将该行打印了，这里就不需要打印了，即 `（m-1-i ）!= i`

```
for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
    list.add(matrix[(m-1)-i][j]);
}
```
第4个：从下往上，如果这一层只有1列，那么第2个循环已经将该列打印了，这里不需要打印，即`(n-1-i) != i`
```                        
for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
    list.add(matrix[j][i]);
}
```

#####  完整代码如下：
```Java []
public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
    		return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0; 

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n)+1)/2;
        //从外部向内部遍历，逐层打印数据
        while(i < count) {
        	for (int j = i; j < n-i; j++) {
				list.add(matrix[i][j]);
			}
        	for (int j = i+1; j < m-i; j++) {
				list.add(matrix[j][(n-1)-i]);
			}
        	
        	for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
				list.add(matrix[(m-1)-i][j]);
			}
        	for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
				list.add(matrix[j][i]);
			}
        	i++;
        }    
        return list;
    }
```