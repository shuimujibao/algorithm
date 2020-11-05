package leetcode.reviewSort;

/**
 * @Auther: tal
 * @Date: 2019-11-28 11:22
 * @Description:
 */
public class BinarySearch {
    /**
     * @description: 递归实现二分查找
     * @author: 孙晓宇
     * @time: 2019-11-28 11:28
     */
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }

    /**
     * @description: 非递归实现二分查找
     * @author: 孙晓宇
     * @time: 2019-11-28 12:31
     */
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        if (key > arr[high] || key < arr[low] || low > high) {
            return -1;
        }
        while (low < high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
