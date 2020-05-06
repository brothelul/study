package com.ddup.leetcode.other;

/**
 * <p> 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 </p>
 *  输入: [-2,1,-3,4,-1,2,1,-5,4],
 *  输出: 6
 *  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author chenglu
 * @date 2020/5/6
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,6}));
    }

    public static int maxSubArray(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            return nums[1];
        }
        result = nums[0];
        int segmentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            segmentSum = Math.max(segmentSum + nums[i], nums[i]);
            result = Math.max(segmentSum, result);
        }
        return result;
    }
}
