package com.ddup.leetcode.other;

/**
 * <p> 数组中存放接下来要走的步数，看是否能走到终点 </p>
 *
 * @author chenglu
 * @date 2020/3/28
 */
public class StepCanArrive {
    public static void main(String[] args) {
        System.out.println(canArrive(new int[] {1, 2, 3, 4, 5}));
    }

    public static boolean canArrive(int[] steps) {
        for (int i = 0;;) {
            if (i > (steps.length - 1)) {
                return false;
            } else if (i == (steps.length - 1)) {
                return true;
            }
            i += steps[i];
        }
    }
}
