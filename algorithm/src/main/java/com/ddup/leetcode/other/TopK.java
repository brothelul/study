package com.ddup.leetcode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p> 查找前topK </p>
 *
 * @author chenglu
 * @date 2020/4/7
 */
public class TopK {
    public static void main(String[] args) {
        topK(new Integer[] {1, 2, 4, 5, 4,8 , 9}, 2);
    }

    public static void topK(Integer[] nums, int k) {
        PriorityQueue<Integer> m = new PriorityQueue<>(Comparator.comparingInt(value -> -value));
        m.addAll(Arrays.asList(nums));
        for (int i = 0; i < k; i++) {
            System.out.println(m.poll());
        }
    }
}
