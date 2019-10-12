package com.ddup.leetcode.stack.q1024;

/**
 * <p> 删除最外层的括号 </p>
 * 求解思路: ( = 1, ) = -1
 *         当括号值相加的结果为0的时候即为一组括号内容，那么头尾的括号都应移除
 * @author chenglu
 * @date 2019/10/12
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String S) {
        String[] strings = S.split("");
        String compare = "(";
        StringBuilder builder = new StringBuilder();
        int length = 0, right = 0, left = 0;
        for (int i = 0; i < strings.length; i++) {
            if (compare.equals(strings[i])) {
                right++;
            } else {
                left++;
            }
            if (right == left) {
                length = 0;
                right = 0;
                left = 0;
            }
            if (length != 0 && right != 1) {
                builder.append(strings[i]);
            }
            length++;
        }
        return builder.toString();
    }
}
