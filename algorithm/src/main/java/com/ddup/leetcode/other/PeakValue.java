package com.ddup.leetcode.other;

/**
 * <p> </p>
 * 输入一串空格分开的整数，相邻不会重复如：1 2 4 3 5，只返回其中一个峰值就可以，比如返回 4 或者 5
 * 峰值定义：大于相邻两个数字就是峰值；对于头尾两个数字，分别大于相邻的一个数字即算峰值
 * @author chenglu
 * @date 2020/3/28
 */
public class PeakValue {
    public static void main(String[] args) {
        System.out.println(getPeakValue("1 2 2 3 5"));
    }

    public static Integer getPeakValue(String s) {
        String[] values = s.split(" ");
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                if (values.length > 1) {
                    if (Integer.valueOf(values[i]) > Integer.valueOf(values[i+1])) {
                        return Integer.valueOf(values[i]);
                    }
                }
                continue;
            }
            if (i == values.length - 1) {
                if (Integer.valueOf(values[i]) > Integer.valueOf(values[i - 1])) {
                    return Integer.valueOf(values[i]);
                }
            }
            if (Integer.valueOf(values[i]) > Integer.valueOf(values[i - 1]) && Integer.valueOf(values[i]) > Integer.valueOf(values[i  + 1])) {
                return Integer.valueOf(values[i]);
            }
        }
        return 0;
    }
}
