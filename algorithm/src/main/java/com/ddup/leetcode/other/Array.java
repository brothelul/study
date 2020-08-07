package com.ddup.leetcode.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2020/7/30
 */
public class Array {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<String> input = new ArrayList<>();
//        while (scanner.hasNextLine()) {
//            input.add(scanner.nextLine());
//        }
        System.out.println(isConvert("abcde", "cdeab") ? "True":"False");
    }


    public static boolean isConvert(String A, String B) {
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }
        if (A.length() == 1 && B.length() == 1) {
            return A.equals(B);
        }
        if (A.length() == 0 || B.length() == 0) {
            return false;
        }
        char firstChar = A.charAt(0);
        char lastChar = A.charAt(A.length() - 1);

        char[] chars = B.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == lastChar && chars[i] == firstChar) {
                StringBuilder sb = new StringBuilder(B.substring(i));
                if ((sb.append(B, 0, i).toString().equals(A))) {
                    return true;
                }
            }
        }
        return false;
    }
}
