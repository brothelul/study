package com.ddup.leetcode.offer;

import java.util.List;

/**
 * <p>
 *     在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/22 0022 21:31
 */
public class Q50 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aaaaa"));
    }

    public static char firstUniqChar(String s) {
        int[] appear = new int[26];
        char[] chars = s.toCharArray();
        char[] serial = new char[26];
        for (int i = 0, j=0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (appear[idx] == 0) {
                serial[j++] = chars[i];
                appear[idx] = 1;
            } else {
                appear[idx] = 2;
            }
        }
        for (int i = 0; i < serial.length; i++) {
            if (serial[i] == 0) {
                break;
            }
            int idx = serial[i] - 'a';
            if (appear[idx] == 1) {
                return serial[i];
            }
        }
        return ' ';
    }
}
