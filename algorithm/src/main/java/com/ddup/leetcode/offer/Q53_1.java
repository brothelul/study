package com.ddup.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/24 0024 20:55
 */
public class Q53_1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Integer.MIN_VALUE - 10);
        System.out.println(search(new int[]{5,7,7,8,8,10}, 8));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }
        return countTargetCount(nums, 0, nums.length -1, target);
    }

    private static int countTargetCount(int[] nums, int start, int end, int target) {
        if (start > end) {
            return  0;
        }
        if (start == end) {
            return nums[start] == target ? 1 : 0;
        }
        if (nums[start] > target || nums[end] < target) {
            return 0;
        }

        int mid = start + ((end - start) >> 1);
        return countTargetCount(nums, start, mid, target) + countTargetCount(nums, mid + 1, end, target);
    }
}
