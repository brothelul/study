package com.ddup.leetcode.other;

/**
 * <p>
 *     给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * </p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 你可以认为每种硬币的数量是无限的。
 * @author chenglu
 * @date 2020/5/8
 */
public class PointExechange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {186,419,83,408}, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        for (int i = 0; i < coins.length; i++) {
        }
        return -1;
    }
}
