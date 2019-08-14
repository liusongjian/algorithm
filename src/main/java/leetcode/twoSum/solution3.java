package leetcode.twoSum;

public class solution3 {
    public int[] twoSum(int[] nums, int target){
        int max = 2047;
        int temp;
        int[] test = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            temp = (target - nums[i]) & max;
            if (test[temp] != 0) {
                return new int[]{test[temp] - 1, i};
            }
            test[nums[i] & max] = i + 1;
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
