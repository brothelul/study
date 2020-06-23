package com.ddup.leetcode.offer;

import java.util.Stack;

/**
 * <p>
 *     定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/23 0023 22:49
 */
public class Q30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.min());   // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.min());   //  --> 返回 0.
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());   // --> 返回 -2.
    }

    /**
     * 思路，寻找局部的最小值
     */
    static class MinStack {
        Stack<Integer> a, b;

        /** initialize your data structure here. */
        public MinStack() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void push(int x) {
            a.push(x);
            if (b.isEmpty() || b.peek() >= x) {
                b.push(x);
            }
        }

        public void pop() {
            if (a.pop().equals(b.peek())) {
                b.pop();
            }
        }

        public int top() {
            return a.isEmpty() ? 0 : a.peek();
        }

        public int min() {
            return b.isEmpty() ? 0 : b.peek();
        }
    }
}
