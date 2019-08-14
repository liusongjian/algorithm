package leetcode.twoSum;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

/**
 * 题目:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        int[] array = initArray();
        int target = initTarget(array);

        solution(array, target, new Solution1());
        solution(array, target, new Solution2());
        solution(array, target, new Solution3());
    }

    /**
     * 随机生成定长数组
     */
    private static int[] initArray() {
        return new Random().ints(10000, 0, 50000).toArray();
    }

    /**
     * 在数组中随机寻找两个数，返回相加之和
     */
    private static int initTarget(int[] a) {
        int length = a.length;
        int[] index = new Random().ints(2, 0, length).toArray();
        return a[index[0]] + a[index[1]];
    }

    /**
     * 调用对应算法，计算耗时
     */
    private static void solution(int[] a, int target, TwoSumSolution solution) {
        int count = 1000;
        int[] result = {};

        long l = LocalTime.now().getNano();
        for (int i = 0; i < count; i++) {
            result = solution.twoSum(a, target);
        }
        long l1 = LocalTime.now().getNano();
        log.info("耗时(ns): {}; 结果: {}; 验证: {}", (l1 - l) / count, Arrays.toString(result), (a[result[0]] + a[result[1]]) == target);
    }
}
