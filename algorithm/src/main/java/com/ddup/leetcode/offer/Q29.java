package com.ddup.leetcode.offer;

import java.util.Arrays;

/**
 * <p>
 *     输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/22 0022 22:43
 */
public class Q29 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                })));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        if (matrix[0].length == 0) {
            return null;
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int resIndex = 0;
        doSpiralOrder(matrix, res, resIndex, 0);
        return res;
    }

    private static void doSpiralOrder(int[][] matrix, int[] res, int resIndex, int term) {
        int x = matrix[0].length - term,
                y = matrix.length - term;
        if (x == 0 || y == 0) {
            return;
        }
        if (x == 1) {
            for (int i = term/2; i < matrix.length - term/2; i++) {
                res[resIndex ++] = matrix[i][term/2];
            }
            return;
        }
        if (y == 1) {
            for (int i = term/2; i < matrix[0].length - term/2; i++) {
                res[resIndex ++] = matrix[term/2][i];
            }
            return;
        }
        // 左 => 右
        for (int i = term/2; i < matrix[0].length - term/2 - 1; i++) {
            res[resIndex++] = matrix[term/2][i];
        }

        // 右 => 下
        for (int i = term/2; i < matrix.length -term/2 - 1; i++) {
            res[resIndex++] = matrix[i][matrix[0].length - term/2 - 1];
        }

        // 下 => 左
        for (int i = matrix[0].length  - term/2 - 1; i > term/2; i--) {
            res[resIndex++] = matrix[matrix.length - term/2 - 1][i];
        }
        // 左 => 上
        for (int i = matrix.length - term/2 - 1; i > term/2; i--) {
            res[resIndex ++] = matrix[i][term/2];
        }
        doSpiralOrder(matrix, res, resIndex, term + 2);
    }
}
