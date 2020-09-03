package com.ddup.leetcode.other;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2020/8/26 0026 20:59
 */
public class DuplicateString {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
        soutCharTimes("a");
    }

    private static void soutCharTimes(String str) {
        if (str.length() == 0 || str.length() ==  1) {
            System.out.println(str);
            return;
        }
        char[] chars = str.toCharArray();
        char pre = chars[0];
        int times = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (pre == chars[i]) {
                times ++;
            } else {
                if (times > 1) {
                    sb.append(pre);
                    sb.append(times);
                } else {
                    sb.append(pre);
                }
                times = 1;
                pre = chars[i];
            }
            if (i == chars.length - 1) {
                sb.append(pre);
                if (times > 1) {
                    sb.append(times);
                }
            }
        }
        System.out.println(sb);
    }
}
