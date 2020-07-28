package com.ddup.leetcode.offer;

import java.util.Arrays;

/**
 * <p>
 *     一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 *     请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/28
 */
public class Q56_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }

    public static int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            k ^= nums[i];
        }
        int mask = 1;
        while ((k&mask) == 0) {
            mask <<= 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & nums[i]) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[] {a, b};
    }
}
