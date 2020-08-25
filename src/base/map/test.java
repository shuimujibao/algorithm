package base.map;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/08/24 22:05:00
 */
public class test {
    public static void main(String[] args) {
        String str1 = "12435";
        String str2 = "54221";
        String res = handle(str1, str2);
        System.out.println("求和结果：" + res);
    }

    private static String handle(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        StringBuilder sb = new StringBuilder();
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
                    sb.append(Integer.parseInt(String.valueOf(str1.charAt(i))));
                    i--;
                } else if (j >= 0) {
                    sb.append(Integer.parseInt(String.valueOf(str2.charAt(j))));
                    j--;
                }
            }
        }
        return sb.toString();
    }
}
