package interview.xiaomi;

import java.util.Stack;

/**
 * @author sunxiaoyu3
 * @description 源字符串数组 ['a','a','a','a','b','b','b','c','c','c']
 * 待输出数组  ['a','3','b','3','c',2]
 * @createTime 2021/06/22 20:00:00
 */
public class Question {

    public static void main(String[] args) {

    }

    public void compress(char[] chars) {

        Stack<Object> stack = new Stack<>();

        int nums = 1;

        for (char temp : chars) {
            if (stack.size() == 0) {
                stack.push(temp);
                continue;
            }

            if (stack.peek().equals(temp)) {
                nums++;
                continue;
            }
            stack.push(nums);
            stack.push(temp);
            nums = 1;
        }
    }
}
