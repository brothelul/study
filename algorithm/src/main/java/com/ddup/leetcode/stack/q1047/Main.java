package com.ddup.leetcode.stack.q1047;

/**
 * <p> 删除重复项 </p>
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 消消乐原理
 * @author chenglu
 * @date 2019/10/22
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("ehflcjmgljhbjecdbbikajfdmabbdcfdiahkaglkeibbfdcljcghhmfgfmfjjfaamlijgihiejmccfiigekaljkmfklldfikjgkb"));
    }

    public static String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (sb.length() > 0 && sb.charAt(sb.length()-1) == chars[i]) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
