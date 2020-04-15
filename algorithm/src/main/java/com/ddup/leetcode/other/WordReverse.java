package com.ddup.leetcode.other;

/**
 * <p> 反转一句英语的所有单词：hello world - > world hello </p>
 *
 * @author chenglu
 * @date 2020/4/14
 */
public class WordReverse {
    public static void main(String[] args) {
        System.out.println(reverse("hello world"));
    }

    public static String reverse(String msg) {
        String[] words = msg.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0 ; i--) {
            if (i == 0) {
                sb.append(words[i]);
                continue;
            }
            sb.append(words[i] + " ");

        }
        return sb.toString();
    }
}
