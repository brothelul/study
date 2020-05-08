package com.ddup.leetcode.other;

/**
 * <p>
 *     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * </p>
 *  输入: [2,2,1]
 *  输出: 1
 * @author chenglu
 * @date 2020/5/8
 */
public class SingleNumberArray {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {1, 1, 2, 3, 3}));
    }

    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
