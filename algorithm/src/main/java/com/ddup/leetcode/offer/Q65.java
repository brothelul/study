package com.ddup.leetcode.offer;

/**
 * <p>
 *     写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/8/7
 */
public class Q65 {
    public static void main(String[] args) {
        System.out.println(add(1, 1));
    }

    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        }

        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }
}
