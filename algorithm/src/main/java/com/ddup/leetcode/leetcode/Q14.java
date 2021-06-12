package com.ddup.leetcode.leetcode;

/**
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenglu
 * @date 2021/6/12
 */
public class Q14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        if (minLength == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = "";
        for (int i = 0; i < minLength; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                char t = strs[j].charAt(i);
                if (t != temp) {
                    return res;
                }
            }
            res += temp;
        }
        return res;
    }
}
