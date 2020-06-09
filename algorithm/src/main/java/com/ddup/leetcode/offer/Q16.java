package com.ddup.leetcode.offer;

/**
 * <p>
 *     实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/9 0009 23:24
 */
public class Q16 {
    public static void main(String[] args) {
        System.out.println(myPow1(2.00000,
                4));
    }

    public static double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            if ((Math.abs(n % 10) % 2) == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (x == 0 && n > 0) {
            return 0;
        }
        if (x == 0 && n < 0) {
            return 0;
        }
        double res = 1;

        for (int i = 0; i < Math.abs(n); i++) {
            res *= x;
        }
        if (n > 0) {
            return res;
        }
        return 1/res;
    }

    /**
     * 如果知道x^2那么就可以通过x^2 * x^2 得到 x^4，而不必一直相乘
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            if ((Math.abs(n % 10) % 2) == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (x == 0 && n > 0) {
            return 0;
        }
        if (x == 0 && n < 0) {
            return 0;
        }
        double res = myPow1(x, n >>> 1);
        res *= res;
        if ((Math.abs(n) & 1) == 1) {
            res *= x;
        }
        if (n > 0) {
            return res;
        } else {
            return 1/res;
        }
    }
}
