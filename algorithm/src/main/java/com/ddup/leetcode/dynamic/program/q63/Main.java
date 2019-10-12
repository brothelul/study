package com.ddup.leetcode.dynamic.program.q63;

/**
 * <p> 有障碍物路径和 </p>
 *
 * @author chenglu
 * @date 2019/9/30
 */
public class Main {
    public static void main(String[] args) {
        int[][] data = new int[][]{{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(data));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length - 1] == 1){
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i-1 < 0 && j-1 < 0) {
                    obstacleGrid[i][j] = 1;
                    continue;
                } else if (i-1<0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    continue;
                } else if (j-1<0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
