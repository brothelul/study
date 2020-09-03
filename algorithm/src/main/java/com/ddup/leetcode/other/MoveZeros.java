package com.ddup.leetcode.other;

import java.util.Arrays;

/**
 * <p>
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/8/29 0029 10:32
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = new int[] {1};
        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int noZeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[noZeroIdx++] = nums[i];
            }
        }
        for (int i = noZeroIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
