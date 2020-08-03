package com.ddup.leetcode.offer;

import java.util.Arrays;

/**
 * <p>
 *     从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 *     2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 *
 * 限制：
 *
 * 数组长度为 5 
 *
 * 数组的数取值为 [0, 13] .
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/8/3 0003 22:24
 */
public class Q61 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[] {4,7,5,9,2}));
    }

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int jokerCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                jokerCount++;
                continue;
            }
            int notValidCount = (nums[i + 1] - nums[i]);
            if (notValidCount > 1 && jokerCount == 0) {
                return false;
            } else if (notValidCount > 2 && jokerCount < 2) {
                return false;
            } else if (notValidCount > 3 && jokerCount < 3) {
                return false;
            } else if (notValidCount == 0) {
                return false;
            }
            if (notValidCount > 1) {
                jokerCount --;
            }
        }
        return true;
    }
}
