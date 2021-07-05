package interview.zijie.forth;

/**
 * @author sunxiaoyu3
 * @description :
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3 [3,2,1]
 * @createTime 2021/07/05 10:13:00
 */
public class Question {

    public int getCommonStr(int[] arr1,int[] arr2){
        if(arr1 == null || arr2 ==null){
            return 0;
        }

        int largest = 0;

        int length1 = arr1.length;
        int length2 = arr2.length;

        int[] arr3 = length1 <= length2 ? arr1 : arr2;

        int pivoat1=0;
        int pivoat2=0;

        int current = 0;
        while(pivoat1 <= arr3.length){
            pivoat1 ++;
            int currentIndex = pivoat1;

            while(pivoat2 <= arr2.length
                    &&currentIndex <length1
                    && arr3[currentIndex] == arr2[pivoat2]){
                currentIndex ++;
                pivoat2 ++;
                current ++;
                continue;
            }

            largest = Math.max(largest,current);
            pivoat2 = 0;
            current = 0;
        }

        return largest;
    }

}
