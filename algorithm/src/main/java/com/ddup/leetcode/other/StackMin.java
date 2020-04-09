package com.ddup.leetcode.other;

import java.util.PriorityQueue;

/**
 * <p> stack实现一个min方法，O(1)的复杂度 </p>
 *
 * @author chenglu
 * @date 2020/4/9
 */
public class StackMin {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(8);
        s.pop();
        s.push(3);
        s.push(4);
        s.push(9);

        System.out.println(stackMin(s));
    }

    private static int stackMin(Stack stack) {
        return stack.min();
    }
}

class Stack {
    int[] nums = new int[1000];
    int currentIndex = 0;
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    public int pop(){
        if (currentIndex == 0) {
            return 0;
        }
        int val = nums[--currentIndex];
        minQueue.remove(val);
        return val;
    }

    public void push(int i) {
        if (currentIndex == nums.length) {
            return;
        }
        nums[++currentIndex] = i;
        minQueue.add(i);
    }

    public int min(){
        return minQueue.peek();

    }
}
