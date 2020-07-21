package com.ddup.leetcode.offer;

import java.util.*;

/**
 * <p>
 *     我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *  
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/21 0021 20:31
 */
public class Q49 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber1(1352));
    }

    /**
     * 此算法超时
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        if (n < 4) {
            return n;
        }
        HashSet<Integer> res = new HashSet<>(1638);
        res.addAll(Arrays.asList(1, 2, 3));
        int i = 4;
        while (res.size() < n) {
            if (i % 2 == 0 && res.contains(i/2)) {
                res.add(i);
            } else if (i %3 == 0 && res.contains(i/3)) {
                res.add(i);
            } else if (i % 5 == 0 && res.contains(i/5)) {
                res.add(i);
            }
            i ++;
        }
        return res.stream().sorted((v1, v2) -> v2 - v1).findFirst().get();
    }

    /**
     *  X(n+1) = min(X(a) * 2, X(b) * 3, X(c) * 5),
     *  因为X(n+1)肯定由一个数*2或*3或*5得到
     * 动态规划求解
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        if (n < 4) {
            return n;
        }
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int na = dp[a] * 2, nb = dp[b] * 3, nc = dp[c] * 5;
            dp[i] = Math.min(Math.min(na, nb), nc);
            int temp = dp[i];
            if (temp == na) {
                a ++;
            }
            if (temp == nb) {
                b ++;
            }
            if (temp == nc) {
                c ++;
            }
        }
        return dp[n-1];
    }
}
