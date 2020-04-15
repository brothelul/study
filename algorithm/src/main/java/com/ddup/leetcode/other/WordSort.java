package com.ddup.leetcode.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            int index = 0;
            int oIndex;
            while (msg.startsWith(currentWord, index)) {
                oIndex = msg.indexOf(currentWord, index);
                index = oIndex + currentWord.length();
                Result result = new Result(oIndex, index + 1);
                results.add(result);
            }
        }

        results = results.stream().sorted(Comparator.comparingInt(Result::getStart))
                .collect(Collectors.toList());
        if (results.size() == 0) {
            return false;
        }
        if (results.size() == 1) {
            if (results.get(0).start.equals(0) && results.get(0).end.equals(msg.length() - 1)) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < results.size(); i++) {
            if (!results.get(i).start.equals(results.get(i - 1).end)) {
                results.remove(i);
                continue;
            }
        }
        return false;
    }
}

class Result {
    Integer start;
    Integer end;

    public Result(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }
}
