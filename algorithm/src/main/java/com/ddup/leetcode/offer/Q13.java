package com.ddup.leetcode.offer;

/**
 * <p>
 *     地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 *     也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 *     但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/6 0006 23:53
 */
public class Q13 {
    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 1));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return count(0, 0 , m, n, k, visited);
    }

    private static int count(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || j < 0 || i == m || j == n) {
            return 0;
        }
        // 计算能否进入方格
        int value = 0, tempI = i, tempJ = j;
        while (tempI > 0) {
            value += tempI % 10;
            tempI /= 10;
        }
        while (tempJ > 0) {
            value += tempJ % 10;
            tempJ /= 10;
        }
        if (k < value) {
            return 0;
        }
        // 已经走过的方格不再走
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + count(i + 1, j, m, n, k, visited)
                + count(i - 1, j, m, n,  k, visited)
                + count(i, j+1, m, n, k, visited)
                + count(i, j - 1, m, n, k, visited);
    }
}
