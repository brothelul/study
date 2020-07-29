package com.ddup.leetcode.offer;

import java.util.Arrays;

/**
 * <p>
 *     输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 *     如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/29
 */
public class Q57 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{2,7,11,15}, 9)));
    }

    /**
     * 时间超出限制
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {nums[i], nums[j]};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j --;
            } else if (sum < target) {
                i ++;
            } else {
                return new int[] {nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
