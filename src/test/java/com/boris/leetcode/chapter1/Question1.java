package com.boris.leetcode.chapter1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: boris
 * @Data: Created on 2020/10/23
 * @Description:
 */

public class Question1 {

    /*
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

        示例：
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
    */
    private int[] nums = new int[]{2, 7, 11, 15};

    @Test
    public void test1() {
        int[] result = this.getIndexBySum1(17);
        System.out.println(result[0] + "," + result[1]);
    }

    public int[] getIndexBySum(int sum) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] getIndexBySum1(int sum) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(sum - nums[i])) {
                return new int[]{numMap.get(sum-nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}
