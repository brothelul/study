package com.ddup.leetcode.offer;

import org.omg.CORBA.INTERNAL;

/**
 * <p>
 *     给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 *     一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/17 0017 20:35
 */
public class Q46 {
    public static void main(String[] args) {
        System.out.println(translateNum(506));
    }

    public static int translateNum(int num) {
        String numStr = String.valueOf(num);
        char[] numChars = numStr.toCharArray();
        if (numChars.length == 1) {
            return 1;
        }
        return doTranslateNum(numChars, 0, false) +
                doTranslateNum(numChars, 0, true);
    }

    private static int doTranslateNum(char[] numChars, int current, boolean chooseNext) {
        int maxIdx = numChars.length - 1;
        if (current >= maxIdx) {
            return 1;
        }
        int next = current + 1;
        if (chooseNext) {
            next = current + 2;
            if (Integer.parseInt(numChars[current] + "") == 0 ||
                    Integer.parseInt(numChars[current] + "" + numChars[current + 1]) > 25) {
                return 0;
            }
        }
        if (next >= numChars.length - 1) {
            return 1;
        }
        return doTranslateNum(numChars, next, true) +
                doTranslateNum(numChars, next, false);
    }
}
