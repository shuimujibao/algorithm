package leetcode.binarysearch;

import java.util.HashMap;
import java.util.Set;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/11/30 20:55:00
 */
public class test {
    public static void main(String[] args) {

    }

    private void getTarget(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, target - i);
        }

        Set<Integer> keyMap = map.keySet();

        int target1 = 0;

        int target2 = 0;

        for (Integer next : keyMap) {
            if (map.get(next).equals(next)) {
                target1 = next;
                target2 = target - next;
                System.out.println("目标值1：" + next + "目标值2" + (target - next));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target1 || arr[i] == target2) {
                System.out.println("下角标：" + i);
            }
        }
    }
}
