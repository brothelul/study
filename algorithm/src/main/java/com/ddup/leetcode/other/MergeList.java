package com.ddup.leetcode.other;

import com.ddup.leetcode.base.ListNode;

/**
 * <p> 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。</p>
 *  输入：1->2->4, 1->3->4
 *  输出：1->1->2->3->4->4
 * @author chenglu
 * @date 2020/5/7
 */
public class MergeList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newList = null, currentNode = newList;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                currentNode.next = new ListNode(l2.val);
                l2 = l2.next;
                currentNode = currentNode.next;
                continue;
            }
            if (l2 == null) {
                currentNode.next = new ListNode(l1.val);
                l1 = l1.next;
                currentNode = currentNode.next;
                continue;
            }
            if (l1.val > l2.val) {
                if (newList ==null) {
                    newList = new ListNode(l2.val);
                    currentNode = newList;
                } else {
                    currentNode.next = new ListNode(l2.val);
                    currentNode = currentNode.next;
                }
                l2 = l2.next;
            } else {
                if (newList ==null) {
                    newList = new ListNode(l1.val);
                    currentNode = newList;
                } else {
                    currentNode.next = new ListNode(l1.val);
                    currentNode = currentNode.next;
                }
                l1 = l1.next;
            }
        }
        return newList;
    }
}
