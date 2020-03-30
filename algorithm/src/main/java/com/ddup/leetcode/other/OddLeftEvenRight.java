package com.ddup.leetcode.other;

import java.util.Arrays;

/**
 * <p> </p>
 * 输入一个int数组，返回一个数组，其中奇数都在左边，偶数都在右边
 * 附加条件 不使用额外的空间
 * @author chenglu
 * @date 2020/3/30
 */
public class OddLeftEvenRight {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(move(new int[]{1, 2, 7, 6, 3, 4})));
    }

    public static int[] move(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int before = nums[i - 1];
            int length = i;
            while (current %2 == 1 && before % 2 == 0 && length > 1) {
                temp = nums[length];
                nums[length] = nums[length - 1];
                nums[length - 1] = temp;
                before = nums[length - 2];
                length--;
            }
        }
        return nums;
    }
}
