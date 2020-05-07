package com.ddup.leetcode.other;

import com.ddup.leetcode.base.ListNode;

import java.util.Stack;

/**
 * <p> 反转一个单链表。 </p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author chenglu
 * @date 2020/5/7
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(6);
        head.next.next = new ListNode(4);
        System.out.println(head);
        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> container = new Stack<>();
        while (head != null) {
            container.push(head);
            head = head.next;
        }
        ListNode newHead = container.pop(), current = newHead;
        while (!container.empty()) {
            ListNode node = container.pop();
            current.next = new ListNode(node.val);
            current = current.next;
        }
        return newHead;
    }

    /**
     * todo 待完成
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        doReverseList(head, head.next);
        return head;
    }

    private static void doReverseList(ListNode head, ListNode next) {
        if (next == null) {
            return;
        }
        head.next = null;
        head.next = head;
        head = next;
        next = next.next;
        doReverseList(head, next);
    }
}
