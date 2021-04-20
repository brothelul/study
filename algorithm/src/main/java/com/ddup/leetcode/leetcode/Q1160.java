package com.ddup.leetcode.leetcode;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenglu
 * @date 2021-04-15 19:47
 */
public class Q1160 {
    
    public static void main(String[] args) {
        System.out.println(countCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
    }
    
    public static int countCharacters(String[] words, String chars) {
        int[] container = new int[26];
        char[] chazs = chars.toCharArray();
        for (int i = 0; i < chazs.length; i++) {
            int idx = chazs[i] - 'a';
            container[idx] ++;
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            int[] temp = new int[26];
            System.arraycopy(container, 0, temp, 0, 26);
            for (int j = 0; j < word.length; j++) {
                int idx = word[j] - 'a';
                if (--temp[idx] < 0) {
                    break;
                }
                if (j == word.length - 1) {
                    count += word.length;
                }
            }
        }
        return count;
    }
}
