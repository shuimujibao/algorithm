package interview.jingdong;

import java.util.PriorityQueue;

/**
 * @author sunxiaoyu3
 * @description 算法
 * @createTime 2020/09/27 09:15:00
 */
public class Question {
    //TODO 无序列数组中如何找到中位数

    public static double median(int[] array) {
        int heapSize = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }
        for (int i = heapSize; i < array.length; i++) {
            if (heap.peek() < array[i]) {
                heap.poll();
                heap.add(array[i]);
            }
        }
        if (array.length % 2 == 1) {
            return (double) heap.peek();
        } else {
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }
}
