package com.ddup.leetcode.leetcode;

import com.ddup.leetcode.base.ListNode;

/**
 * Function:
 *  给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * @author chenglu
 * @date 2021-06-01 22:48
 */
public class Q206 {
    
    private ListNode newHead;
    
    public static void main(String[] args) {
        ListNode header = new ListNode(5);
        header.next = new ListNode(3);
        header.next.next = new ListNode(4);
        System.out.println(reverseList(header));
    }
    
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
