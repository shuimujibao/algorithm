package  leetcode.reviewSort;

public class MergeSort {
    //归并需要的辅助数组
    private static int[] helpArr;

    public static void sort(int[] arr) {
        helpArr = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int heigh) {
        //将数组进行划分
        int mid = (low + heigh) / 2;
        //将数组左边进行排序
        if (low < mid) {
            sort(arr, low, mid);
        }
        //将数组右边进行排序
        if (heigh > mid + 1) {
            sort(arr, mid + 1, heigh);
        }
        //合并两边的元素
        merge(arr, low, heigh, mid);
    }

    private static void merge(int[] arr, int low, int heigh, int mid) {
        //左边界索引
        int left = low;
        //右边界索引
        int right = heigh;
        //临时变量
        int t = 0;
        while (left <= mid && right <= heigh) {
            if (arr[left] <= arr[right]) {
                helpArr[t++] = arr[left++];
            } else {
                helpArr[t++] = arr[right++];
            }
        }
        //当两组序列，左边有剩余时
        while (left <= mid) {
            helpArr[t++] = arr[left++];
        }
        //当两组序列，右边有剩余时
        while (right <= heigh) {
            helpArr[t++] = arr[right++];
        }
        //将临时数组的值拷贝纸原数组中
        t = 0;
        while (left <= right) {
            arr[left++] = helpArr[t++];
        }
    }
}
