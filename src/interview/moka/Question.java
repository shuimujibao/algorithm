package interview.moka;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/08/25 11:10:00
 */
public class Question {
    public static void main(String[] args) {
        String str1 = "12435";
        String str2 = "4221";

        int l1 = Integer.parseInt(str1);
        int l2 = Integer.parseInt(str2);
        String res = handle(str1, str2);
        System.out.println("求和结果：" + res);
        System.out.println(l1 + l2);
    }

    private static String handle(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder sm = new StringBuilder();
        int temp = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                int nums = Integer.parseInt(String.valueOf(str1.charAt(i))) + Integer.parseInt(String.valueOf(str2.charAt(j))) + temp;
                sb.append(nums % 10);
                temp = temp / 10;
                i--;
                j--;
            } else if (i < 0 || j < 0) {
                if (i >= 0) {
                    sm.append(Integer.parseInt(String.valueOf(str1.charAt(i))));
                    i--;
                } else if (j >= 0) {
                    sm.append(Integer.parseInt(String.valueOf(str2.charAt(j))));
                    j--;
                }
            }
        }
        sm.append(sb);
        return sm.toString();
    }
}
