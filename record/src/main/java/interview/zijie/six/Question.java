package interview.zijie.six;

/**
 * @author sunxiaoyu3
 * @description 从指定十进制数组中去掉m个数字，希望留下的结果最大。
 * 例如：指定 345271
 * m=1 res=45271
 * m=2 res=5271
 * @createTime 2021/07/21 16:06:00
 */
public class Question {

    public int[] getMax(int[] arr, int m) {

        int[] result = new int[arr.length - m + 1];

        int stopLimit = 0;

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] < arr[i + 1]) {
                stopLimit++;
            } else {
                result[j++] = arr[i];
            }
            if (stopLimit == m) {
                break;
            }
        }
        return result;
    }
}
