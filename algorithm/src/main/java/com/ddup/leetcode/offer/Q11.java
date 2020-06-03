package com.ddup.leetcode.offer;

/**
 * <p>
 *     把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/3 0003 23:19
 */
public class Q11 {
    public static void main(String[] args) {
        System.out.println(minArray(new int[] {1, 3, 5}));
    }

    public static int minArray(int[] numbers) {

        int i = 0, j = numbers.length - 1;
        while (j > i + 1) {
            int half = (j - i)/2 + i;
            if (numbers[half] > numbers[j]) {
                i = half;
                // 如果两边的数相等，那么最小数不一定会出现在那个区间，这个时候缩小区间距离
            } else if (numbers[half] == numbers[i]){
                j = j - 1;
                i = i + 1;
            } else {
                j = half;
            }
        }
        return Math.min(numbers[i], numbers[j]);

    }
}
