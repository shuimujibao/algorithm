package  interview.yuanfudao;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sunxiaoyu3
 * @description 给定一个数组
 * 输入：2   5   7   6   4    9    3   2
 * 坐标：0   1   2   3   4    5    6   7
 * 返回：1   2   5   5   5   -1   -1   -1
 * 返回比当前元素后面第一个大的元素的索引坐标，不存在则返回-1
 *
 * <p>
 * 时间复杂度是0(n)
 * 提示用栈
 * <p>
 * @createTime 2020/10/30 09:32:00
 */
public class Question {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 7, 6, 4, 9, 3, 2};
        System.out.println(Arrays.toString(handleArr(arr)));
    }

    private static int[] handleArr(int[] array) {
        if (array == null) {
            return null;
        }
        int size = array.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.empty()) {
                stack.add(array[i]);
                continue;
            }
            if (stack.peek() >= array[i]) {
                stack.add(array[i]);
                continue;
            }
            while (!stack.empty() && stack.peek() < array[i]) {
                stack.pop();
                stack.add(array[i]);
                result[i - 1] = i;
            }
        }
        return result;
    }
}
