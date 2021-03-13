package com.ddup.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenglu
 * @date 2021-03-13 10:24
 */
public class Q1002 {
    
    public static void main(String[] args) {
        System.out.println(commonChars(new String[] {"bella","label","roller"}));
    }
    
    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] temp = new int[26];
        for (int i = 0; i < A.length; i++) {
            int[] container = new int[26];
            String s = A[i];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char chaz = chars[j];
                container[chaz - 'a'] += 1;
            }
            for (int j = 0; j < temp.length; j++) {
                if (i > 0) {
                    temp[j] = Math.min(temp[j], container[j]);
                } else {
                    temp[j] = container[j];
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                for (int j = 0; j < temp[i]; j++) {
                    result.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return result;
    }
    
    
}
