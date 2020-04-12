package com.ddup.leetcode.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  是输入[I love byte bytedance] Ilovebytebytedance
 * 然后判断中括号里的单词能否组成括号外的语句
 *  中括号里的单词用空格符隔开，括号外的语句不能由单词重叠组成
 * 如果输入这个
 *  [I love byte bytedance] Ilovebytedance，预期结果返回true
 *
 * @author chenglu
 * @date 2020/4/12 0012 23:43
 */
public class WordSort {
    public static void main(String[] args) {
        String[] words = new String[]{"I", "love", "byte", "bytedance"};
        String msg = "Ilovebytedance";
        System.out.println(sortResult(words, msg));
    }

    public static boolean sortResult(String[] words, String msg) {
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            Pattern pattern = Pattern.compile(currentWord);
            Matcher matcher = pattern.matcher(msg);
        }
    }
}
