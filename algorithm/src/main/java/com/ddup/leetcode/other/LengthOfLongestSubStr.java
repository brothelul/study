package com.ddup.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * </p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author chenglu
 * @date 2020/5/13
 */
public class LengthOfLongestSubStr {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asjrgapa"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        if (s == null || s.length() == 0) {
            return maxLength;
        }
        char[] chars = s.toCharArray();
        String maxStr = "";
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        for (int i = 0; i < chars.length; i++) {
            if (maxStr.contains(String.valueOf(chars[i]))) {
                nums.add(i);
            }
            maxStr += String.valueOf(chars[i]);
        }
        if (nums.size() == 1) {
            return s.length();
        }

        for (int i = 0; i < nums.size() -1; i++) {
            maxLength = Math.max(maxLength, nums.get(i + 1) - nums.get(i));
        }
        return maxLength;
    }
}
