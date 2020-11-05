package leetcode.greedyalgorithm;

/**
 * @author sunxiaoyu3
 * @description 种植花朵
 * @createTime 2020/08/21 14:17:00
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {

        int[] flowerbed = {1, 0, 0, 0, 1, 0, 1, 0, 0, 1};

        int n = 5;

    }

    /**
     * @return : boolean
     * @description: <p>题目描述：flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。</p>
     * @author: sunxiaoyu3
     * @date: 2020-08-21 14:18
     * @param: [flowerbed, n]
     * @throws:
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }

            int pre = i == 0 ? 0 : flowerbed[i - 1];

            int next = i == (flowerbed.length - 1) ? 0 : flowerbed[i + 1];

            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
