package com.ddup.leetcode.stack.q496;

import java.util.Arrays;

/**
 * <p> </p>
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * @author chenglu
 * @date 2019/10/23
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,2}, new int[]{1, 3, 4, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            boolean find = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    find = true;
                }

                if (nums1[i] != nums2[j] && !find) {
                    continue;
                }

                if (nums1[i] < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
                if (j == nums2.length-1 && nums1[i] >= nums2[j]) {
                    nums1[i] = -1;
                }
            }
        }

        return nums1;
    }
}
