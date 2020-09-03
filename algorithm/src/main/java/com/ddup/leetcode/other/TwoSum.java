package com.ddup.leetcode.other;

import java.util.Arrays;

/**
 * <p>
 *     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/9/3
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 1 || nums.length == 0) {
            return null;
        }
        int idx1 = 0, idx2 = 0;
        boolean find = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (find) {
                break;
            }
            idx1 = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    idx2 = j;
                    find = true;
                    break;
                }
            }
        }
        return new int[] {idx1, idx2};
    }
}
