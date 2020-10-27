package sort;

import java.util.Arrays;

/**
 * 希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
 * 是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法。
 * 该方法因D.L.Shell于1959年提出而得名。
 */
public class ShellsSort {
    public static void main(String[] args) {
        int[] array = {5,1,8,0,6,4,3,9,2};
        shellsSort2(array);
        System.out.println(Arrays.toString(array));
    }
    private static void shellsSort(int[] array){
        int len = array.length;
        while (len>0){
            // 步长
            len = len >> 1;
            for (int i = 0; i < len; i++){
                for (int j = i + len; j < array.length; j += len) {
                    // 此处与插入排序相同 从以步长组成的新序列中第二个数开始比较
                    // cur为已经排好序的数组的末尾 temp是正在比较的位置
                    // 相较于插入排序while循环次数有效减少 即：比较替换次数减少
                    int temp = j - len;
                    int cur = array[j];
                    while (temp >= 0 && cur < array[temp]){
                        array[temp+len] = array[temp];
                        temp -= len;
                    }
                    array[temp+len] = cur;
                }
            }
        }
    }

    /**
     * 优化细节
     */
    private static void shellsSort2(int[] array){
        int len = array.length;
        while ((len>>=1) > 0){
            for (int i = len; i < array.length ; i+= len){
                // 将当前元素从后向前开始比较  cur为已经排好序的数组的末尾 temp是比较位置
                int cur = array[i];
                int temp = i-len;
                while (temp >= 0 && cur < array[temp]){
                    array[temp+len] = array[temp];
                    temp -=len;
                }
                array[temp+len] = cur;
            }
        }
    }
}
