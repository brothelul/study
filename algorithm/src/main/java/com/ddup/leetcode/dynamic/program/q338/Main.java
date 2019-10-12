package com.ddup.leetcode.dynamic.program.q338;

import java.util.Arrays;

/**
 * <p> 比特位计数 </p>
 *
 * @author chenglu
 * @date 2019/9/30
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(10)));
    }

    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        int value = 0;
        for (int i = 0; i <= num; i++) {
            if (i==0) {
                result[i] = 0;
                continue;
            }
            result[i] = result[i>>2-1] + (value = (value == 0 ? 1 : 0));
        }
        return result;
    }
}
