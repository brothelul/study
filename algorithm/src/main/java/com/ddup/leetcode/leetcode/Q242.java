package com.ddup.leetcode.leetcode;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenglu
 * @date 2021-02-24 13:31
 */
public class Q242 {
    
    public static void main(String[] args) {
        System.out.println(isAnagram("ac", "bb"));
    }
    
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        char[] container = new char[26];
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                container[chars1[i] - 'a'] += 1;
                container[chars2[i] - 'a'] -= 1;
            }
        }
        for (int i = 0; i < container.length; i++) {
            if (container[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
