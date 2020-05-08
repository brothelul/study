package com.ddup.leetcode.other;

import java.util.Arrays;

/**
 * <p>
 *     给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * </p>
 *  输入: [1,2,3,1]
 *  输出: true
 * @author chenglu
 * @date 2020/5/8
 */
public class DuplicateArrayCheck {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 2, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums).distinct().count();
    }
}
