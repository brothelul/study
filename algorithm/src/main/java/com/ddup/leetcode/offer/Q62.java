package com.ddup.leetcode.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * <p>
 *     0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 *     求出这个圆圈里剩下的最后一个数字。
 *     例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 *     则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * 通过次数41,475提交次数66,535
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/8/4 0004 22:47
 */
public class Q62 {
    public static void main(String[] args) {
        System.out.println(lastRemaining1(5, 1));
    }

    public static int lastRemaining(int n, int m) {
        if (m == 1) {
            return 0;
        }
        List<Integer> queue = new LinkedList<>();
        IntStream.range(0, n).forEach(queue::add);
        int currentIndex = 0, currentM = m;
        while (queue.size() > 1) {
            if (queue.size() ==2) {
                return (m % 2) == 0 ? queue.get(0) : queue.get(1);
            }
            if (currentM == 1) {
                queue.remove(currentIndex);
                currentM = m;
            }
            currentM --;
            currentIndex ++;
            if (currentIndex >= queue.size()) {
                currentIndex = 0;
            }
        }
        return queue.get(0);
    }

    public static int lastRemaining1(int n, int m) {
        if (m < 1 || n < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i < n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
