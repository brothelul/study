package com.ddup.leetcode.offer;

import com.ddup.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *     输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/1 0001 22:39
 */
public class Q6 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint2(head)));
    }

    /**
     * 栈方法求解
     * @param head 头结点
     * @return 结果集
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        int[] result = new int[stack.size()];
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    /**
     * 递归方法求解
     * @param head 头结点元素
     * @return 结果
     */
    public static int[] reversePrint2(ListNode head) {
        List<Integer> result = new ArrayList<>();
        reverse(head, result);
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void reverse(ListNode node, List<Integer> container) {
        if (node.next == null) {
            container.add(node.val);
            return;
        }
        reverse(node.next, container);
        container.add(node.val);
    }
}
