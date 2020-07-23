package com.ddup.leetcode.offer;

/**
 * <p>
 *     在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *     输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/23 0023 21:20
 */
public class Q51 {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7,5,6,4}));
    }

    /**
     * 超时，需借助归并
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int dpn = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    temp++;
                }
            }
            dpn += temp;
        }
        return dpn;
    }
}
