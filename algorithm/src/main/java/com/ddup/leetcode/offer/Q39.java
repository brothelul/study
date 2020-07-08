package com.ddup.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/8 0008 20:47
 */
public class Q39 {
    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[] {2,2,1,1,1,2,2}));
    }

    /**
     * hash表法，时间和空间复杂度均为O(N)
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> times = new HashMap<>(nums.length/2);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int currentTime = times.getOrDefault(num, 0) + 1;
            if (currentTime >= length/2) {
                return num;
            }
            times.put(num, currentTime);
        }
        return 0;
    }

    /**
     * 摩尔投票法，众数和非众数相抵消的概念
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int x = 0;
        int vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                x = nums[i];
                vote ++;
                continue;
            }
            if (x == nums[i]) {
                vote ++;
            } else {
                vote --;
            }
        }
        return x;
    }
}
