package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 最好时间复杂度O(n)
 * 最坏时间复杂度O(n^2)
 * 平均时间复杂度O(n^2)
 * 数组越有序排序时间复杂度越低
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5,1,8,0,6,4,3,9,2};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 将一个待排序的元素，插入到前面已经排好序的一组元素的合适位置上去，直到元素全部插完为止。
     *
     * 当插入第i(i>=1)个元素时，前面的array[0]至array[i-1]已经排好序，
     * 此时用array[i]的值与已排好序的数组从后至前比较，
     * 如果原值大于待排序的值，则原值向后移动一位，
     * 直到找到原值小于等于array[i]的位置，将array[i]插入此位置后一位。
     */
    private static void insertSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        // 从第二个元素开始遍历
        for (int i = 1; i <= array.length-1 ; i++){
            int cur = array[i];
            // 将当前元素从后向前开始比较  cur为已经排好序的数组的末尾 temp是比较位置
            int temp = i-1;
            while (temp >= 0 && cur < array[temp]){
                array[temp+1] = array[temp];
                temp --;
            }
            array[temp+1] = cur;
        }
    }
}
