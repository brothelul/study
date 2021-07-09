package com.ddup.leetcode.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenglu
 * @date 2021-07-09 17:41
 */
public class Q5 {
    
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbbbd"));
    }
    
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length < 2) {
            return s;
        }
        int maxLength = 1, begin = 0;
        // dp[m, n] = dp[m + 1, n - 1] && chars[m] == chars[n]
        boolean[][] dps = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dps[i][i] = true;
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j <length; j++) {
                int l = i + j - 1;
                if (l >= length) {
                    break;
                }
                if (chars[j] != chars[l]) {
                    dps[j][l] = false;
                } else {
                    if (l - j < 3) {
                        dps[j][l] = true;
                    } else {
                        dps[j][l] = dps[j + 1] [l - 1];
                    }
                }
                
                if (dps[j][l] && l - j + 1 > maxLength) {
                    maxLength = l - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
}
