package com.ddup.leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenglu
 * @date 2021-06-20 23:21
 */
public class Q961 {
    
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[] {1,2,3,3}));
    }
    
    public static int repeatedNTimes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if (temp.contains(num)) {
                return num;
            }
            temp.add(num);
        }
        return 0;
    }
}
