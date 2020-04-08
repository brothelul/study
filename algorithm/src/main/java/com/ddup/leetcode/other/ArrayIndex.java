package com.ddup.leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p> 给一个数组和一个整数，输出数组中所有和为给定整数的元素下标 </p>
 *
 * @author chenglu
 * @date 2020/4/8
 */
public class ArrayIndex {
    static Map<String, Integer> map = new HashMap<>(16);

    public static void main(String[] args) {
        soutIndex(new int[]{1, 1, 1, 5, 3, 2}, 3, 0, 6);
    }

    public static void soutIndex(int[] nums, int val, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return;
        }
        String startKey = startIndex + "";
        int result = nums[startIndex], result2 = result;
        for (int i = startIndex + 1; i < endIndex; i++) {
            startKey +=  "-" + i;
            String startKey2 = startIndex + "-" + i;
            String finalStartKey = startKey;
            String machKey = map.keySet().stream().filter(finalStartKey::contains).findFirst().orElse(null);
            if (Objects.nonNull(map.get(machKey)) && map.get(machKey) > val) {
            } else {
                result += nums[i];
                if (result == val) {
                    System.out.println(finalStartKey);
                }
                map.put(finalStartKey, result);
            }
            result2 = nums[startIndex] + nums[i];
            Integer re = map.getOrDefault(startKey2, null);
            if (Objects.isNull(re) && result2 == val) {
                System.out.println(startKey2);
            }
            map.put(startKey2, result2);
        }
        soutIndex(nums, val, startIndex + 1, endIndex);
    }
}
