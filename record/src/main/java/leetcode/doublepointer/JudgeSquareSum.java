package leetcode.doublepointer;

/**
 * @author sunxiaoyu
 * @date: 2020-08-04 14:42
 * @description: 题目描述：判断一个非负整数是否为两个整数的平方和。
 */
public class JudgeSquareSum {
    /**
     * 双指针
     *
     * @param target
     * @return
     */
    public boolean judgeSquareSum(int target) {
        if (target < 0) {
            return false;
        }
        int x = 0;
        int y = (int) Math.sqrt(target);
        while (x <= y) {
            int temp = x * x + y * y;
            if (temp == target) {
                return true;
            } else if (temp < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JudgeSquareSum arr = new JudgeSquareSum();
        System.out.println(arr.judgeSquareSum(3));
    }
}
