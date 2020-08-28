package com.ddup.leetcode.other;

import java.util.Arrays;

/**
 * <p>
 *     给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/8/28
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 9})));
    }

    public static int[] plusOne(int[] digits) {
        boolean up = true;
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] == 9 && up) {
                digits[i] = 0;
                up = true;
            } else if (up) {
                digits[i] ++;
                up = false;
            }
        }
        if (!up) {
            return digits;
        }
        int[] res = new int[digits.length + 1];
        System.arraycopy(digits, 0, res, 1, digits.length);
        res[0] = 1;
        return res;
    }
}
