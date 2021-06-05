package com.ddup.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenglu
 * @date 2021-05-06 16:24
 */
public class Q386 {
    
    public static void main(String[] args) {lexicalOrder(5000000);
        System.out.println();
    }
    
    public static List<Integer> lexicalOrder(int n) {
        PriorityQueue<String> queue = new PriorityQueue<>(String::compareTo);
        for (int i = 1; i < n + 1; i++) {
            queue.offer(String.valueOf(i));
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(Integer.valueOf(queue.poll()));
        }
        return res;
    }
}
