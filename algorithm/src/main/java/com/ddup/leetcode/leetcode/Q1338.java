package com.ddup.leetcode.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 *
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * 示例 2：
 *
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * 示例 3：
 *
 * 输入：arr = [1,9]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 * 示例 5：
 *
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * arr.length 为偶数
 * 1 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reduce-array-size-to-the-half
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenglu
 * @date 2021-04-08 18:02
 */
public class Q1338 {
    
    public static void main(String[] args) {
        System.out.println(minSetSize(new int[] {7,7,7,7,7,7}));
    }
    
    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            container.put(arr[i], container.getOrDefault(arr[i], 0) + 1);
        }
        int length = arr.length/2;
        int current = 0;
        List<Map.Entry<Integer, Integer>> ordered = container.entrySet().stream()
                .sorted((v1, v2) -> v2.getValue() - v1.getValue())
                .collect(Collectors.toList());
        for (int i = 0; i < ordered.size(); i++) {
            Map.Entry<Integer, Integer> node = ordered.get(i);
            current += node.getValue();
            if (current >= length) {
                return i + 1;
            }
        }
        return length;
    }
}
