package com.ddup.leetcode.offer;

/**
 * <p>
 *     输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *  
 *
 * 限制：
 *
 * 1 <= n < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/12 0012 23:16
 */
public class Q43 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }

    public static int countDigitOne(int n) {
        int high = n/10, low = 0, digit = 1, current = n % 10, res = 0;
        while (high != 0 || current != 0) {
            if (current == 0) {
                res += digit * high;
            } else if (current == 1) {
                res += digit * high + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += current * digit;
            current = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
