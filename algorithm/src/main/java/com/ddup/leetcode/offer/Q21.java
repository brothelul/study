package com.ddup.leetcode.offer;

import java.util.Arrays;

/**
 * <p>
 *     输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/12 0012 23:06
 */
public class Q21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }

    /**
     * 性能较差
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int m = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > -1 ; j--) {
                if ((nums[j] & 1) == 1) {
                    m = j;
                    break;
                }
            }
            if (i >= m) {
                return nums;
            }
            if ((nums[i] & 1) == 0) {
                temp = nums[i];
                nums[i] = nums[m];
                nums[m] = temp;
            }
        }
        return nums;
    }
}
