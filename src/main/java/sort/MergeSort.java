package sort;

import java.util.Arrays;

/**
 * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 * 归并排序是一种稳定的排序方法。
 * 场景： ArrayList#sort 排序源码
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5,1,8,0,6,4,3,9};
        sort(nums,0,nums.length -1);
        System.out.println(Arrays.toString(nums));
    }
    private static void sort(int[] arr,int left,int right){
        // 终止条件
        if( left == right ){
            return;
        }
        // 中间值
        int mid = left + ((right - left) >> 1);

        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr,left,mid,right);
    }
    private static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];

        int i = 0;
        // 左右两侧遍历起始位置
        int l = left;
        int r = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(l <= mid && r <= right) {
            temp[i++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }

        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(l <= mid) {
            temp[i++] = arr[l++];
        }
        while(r <= right) {
            temp[i++] = arr[r++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}
