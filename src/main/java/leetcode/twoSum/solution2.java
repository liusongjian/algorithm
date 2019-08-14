package leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

public class solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
