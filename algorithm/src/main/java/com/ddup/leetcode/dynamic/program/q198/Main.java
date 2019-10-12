package com.ddup.leetcode.dynamic.program.q198;

/**
 * <p> 打家劫舍 </p>
 *
 * @author chenglu
 * @date 2019/9/30
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            if (i == 0){
                result[i] = nums[i];
                continue;
            }
            int current = ((i-2 >= 0) ? result[i-2] : 0) + nums[i];
            int before = result[i-1];
            result[i] = current > before ? current : before;
        }
        return result[result.length-1];
    }
}
