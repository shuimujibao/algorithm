package interview.meituan;

import java.util.Stack;

/**
 * @author sunxiaoyu3
 * @description 两个未知长度的字符串数字相加
 * @createTime 2020/11/19 20:05:00
 */
public class Question {


    public static void main(String[] args) {
        System.out.println(sum("99", "1"));
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

        int m = 0;
        int n = 0;
        while (!stack1.empty() && !stack2.empty()) {
            n = (stack1.peek() + stack2.peek() + m) % 10;
            m = (stack1.peek() + stack2.peek()) / 10;
            stack1.pop();
            stack2.pop();
            result.add(n);
        }

        int p = 0;
        int q = 0;

        boolean flag = (m != 0);

        while (!stack1.empty()) {
            if (flag) {
                p = (stack1.peek() + m + q) % 10;
                q = (stack1.peek() + m) / 10;
                m = 0;
                result.add(p);
            } else {
                result.add(stack1.peek());
            }
            stack1.pop();
        }

        while (!stack2.empty()) {
            if (flag) {
                p = (stack2.peek() + m + q) % 10;
                q = (stack2.peek() + m) / 10;
                m = 0;
                result.add(p);
            } else {
                result.add(stack2.peek());
            }
            stack2.pop();
        }

        while (!result.empty()) {
            sb.append(result.pop());
        }

        return sb.toString();
    }
}
