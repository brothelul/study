package com.ddup.leetcode.dynamic.program.q62;

/**
 * <p> 无障碍物，获取可走路径 </p>
 *
 * @author chenglu
 * @date 2019/9/30
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-1 < 0 || j-1 < 0) {
                    a[i][j] = 1;
                    continue;
                }
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }
        return a[m-1][n-1];
    }
}
