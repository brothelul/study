package com.ddup.leetcode.offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * <p>
 *     输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/8 0008 21:08
 */
public class Q40 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers1(new int[]{0,0,1,2,4,2,2,3,1,4}, 8)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return arr;
        }
        return Arrays.stream(arr)
                .sorted()
                .limit(k)
                .toArray();
    }

    public static int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length == 0) {
            return arr;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
