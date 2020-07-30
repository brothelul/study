package com.ddup.leetcode.offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>
 *     给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/30
 */
public class Q59_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2- v1);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.add(nums[i]);
                res[resIndex] = queue.peek();
                continue;
            } else if (i == k) {
                resIndex = 1;
            }
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            res[resIndex++] = queue.peek();
        }
        return res;
    }
}
