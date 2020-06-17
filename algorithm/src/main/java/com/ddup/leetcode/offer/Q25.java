package com.ddup.leetcode.offer;

import com.ddup.leetcode.base.ListNode;

/**
 * <p>
 *     输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/17 0017 22:39
 */
public class Q25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists1(l1, l2));
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    /**
     * 遍历
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode current = null;
        while (l1 != null) {
            while (l2 != null) {
                if (l1 == null) {
                    current.next = l2;
                    break;
                }
                if (l1.val >= l2.val) {
                    if (head == null) {
                        head = l2;
                        l2 = l2.next;
                        current = head;
                    } else {
                        current.next = l2;
                        l2 = l2.next;
                        current = current.next;
                    }
                } else {
                    if (head == null) {
                        head = l1;
                        l1 = l1.next;
                        current = head;
                    } else {
                        current.next = l1;
                        l1 = l1.next;
                        current = current.next;
                    }
                }

            }
            if (l1 != null) {
                current.next = l1;
            }
            break;
        }

        return head;
    }
}
