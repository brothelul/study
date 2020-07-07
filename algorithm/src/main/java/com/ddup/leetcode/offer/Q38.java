package com.ddup.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>
 *     输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/7 0007 20:53
 */
public class Q38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("ryawrowv")));
    }

    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb;
        LinkedList<String> result = new LinkedList<>();
        Map<String, Boolean> levelMap = new HashMap<>(16);
        for (int i = 0; i < chars.length; i++) {
            if (result.size() == 0) {
                result.add(String.valueOf(chars[i]));
                continue;
            }
            String current = result.getFirst();
            while (current.length() < (i + 1)) {
                current = result.removeFirst();
                for (int j = 0; j <= current.length(); j++) {
                    sb = new StringBuilder(current);
                    sb.insert(j, chars[i]);
                    String temp = sb.toString();
                    if (levelMap.get(temp) == null) {
                        result.add(temp);
                    }
                }
                current = result.getFirst();
            }

        }
        return result.toArray(new String[0]);
    }
}
