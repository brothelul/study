package com.ddup.leetcode.other;

/**
 * <p>
 *     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/8/7
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    // dp(n) = dp(n-1) + dp(n-2), dp(n-1) = 1
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int dp_n = 0, dp_n_1 = 1, dp_n_2 = 0;
        for (int i = 1; i <= n; i++) {
            dp_n = dp_n_1 + dp_n_2;
            dp_n_2 = dp_n_1;
            dp_n_1 = dp_n;
        }
        return dp_n;
    }
}
