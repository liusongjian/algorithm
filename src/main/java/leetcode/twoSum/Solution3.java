package leetcode.twoSum;

/**
 * 复杂度分析：
 *
 * 时间复杂度：O(n)，
 * 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
 *
 * 空间复杂度：O(n)，
 * 与Hash算法类似，将元素的值映射为数组下标，遍历一次，查找插值所代表的下表是否存在与数组中
 *
 */
public class Solution3 implements TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        int max = maxSizeFor(target);
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

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private static int maxSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY - 1 : n;
    }
}
