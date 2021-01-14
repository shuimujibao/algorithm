### 解题思路
四指针。分别通过四个指针对二维数组的四个边界进行分界。从左到右，从上到下，从右到左，从下到上，直至遍历完毕为止。时间复杂度：O(mn)。
![image.png](https://pic.leetcode-cn.com/1603333032-svVZMQ-image.png)


### 代码

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 ||matrix[0].length == 0){
            return result;
        }

        //二维矩阵的维数
        int row = matrix.length;
        int col = matrix[0].length;

        //四指针(上、下、左、右)
        int up = 0;
        int down = row - 1;
        int left = 0;
        int right = col - 1;

        while(true){
            //1. 先记录上横行
            for(int i = left; i <= right; i++){
                result.add(matrix[up][i]);
            }
            up++;   //横行下移
            //边界判断
            if(up > down){
                break;
            }

            //2. 记录右竖行
            for(int i = up; i <= down; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(left > right){
                break;
            }

            //3. 记录下横行
            for(int i = right; i >= left; i--){
                result.add(matrix[down][i]);
            }
            down--;
            if(up > down){
                break;
            }

            //4. 记录左竖行
            for(int i = down; i >= up; i--){
                result.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }
        return result;
    }
}
```