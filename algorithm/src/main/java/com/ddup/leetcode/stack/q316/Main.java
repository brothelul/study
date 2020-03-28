package com.ddup.leetcode.stack.q316;

/**
 * <p> 去除重复字母 </p>
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @author chenglu
 * @date 2019/12/6
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return s;
        }
        for (int i = 0; i < chars.length; i++) {

        }
        return s;
    }
}

