package interview.meituan;

import java.util.Stack;

/**
 * @author sunxiaoyu3
 * @description 两个未知长度的字符串数字相加
 * @createTime 2020/11/19 20:05:00
 */
public class Question {


    public static void main(String[] args) {
        System.out.println(sum("909", "1"));
    }

    private static String sum(String a, String b) {

        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        StringBuilder sb = new StringBuilder();

        Stack<Integer> result = new Stack<>();

        for (char temp :
                chara) {
            stack1.add(Integer.parseInt(String.valueOf(temp)));
        }

        for (char temp :
                charb) {
            stack2.add(Integer.parseInt(String.valueOf(temp)));
        }

        //商
        int m = 0;
        //余数
        int n;
        while (!stack1.empty() && !stack2.empty()) {
            n = (stack1.peek() + stack2.peek() + m) % 10;
            m = (stack1.peek() + stack2.peek()) / 10;
            stack1.pop();
            stack2.pop();
            result.add(n);
        }

        //是否需要进位标志   ---  "9999" + "1"  此时为true
        boolean flag = (m != 0);

        Stack<Integer> stackTemp = stack1.empty() ? stack2 : stack1;

        int p;
        int q = 0;
        while (!stackTemp.empty()) {
            if (flag) {
                p = (stackTemp.peek() + m + q) % 10;
                q = (stackTemp.peek() + m + q) / 10;
                m = 0;
                result.add(p);
            } else {
                result.add(stackTemp.peek());
            }
            stackTemp.pop();
        }

        if (q != 0) {
            result.add(1);
        }

        //求和结果
        while (!result.empty()) {
            sb.append(result.pop());
        }

        return sb.toString();
    }
}
