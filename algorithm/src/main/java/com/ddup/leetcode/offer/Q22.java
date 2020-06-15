package com.ddup.leetcode.offer;

import com.ddup.leetcode.base.ListNode;

/**
 * <p>
 *     输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/15 0015 23:16
 */
public class Q22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(getKthFromEnd1(head, 4));
    }

    /**
     * 通用方法
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return head;
        }
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length ++;
            current = current.next;
        }
        if (length <= k) {
            return head;
        }
        current = head;
        int index = (length - k);
        while ( index > 0) {
            index --;
            current = current.next;
        }
        return current;
    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        int k1 = k, k2 = k;
        boolean first = true;
        ListNode l1 = head;
        ListNode l2 = head;
        while (l1 != null) {
            // 走完一次
            if (k1 == 0) {
                k1 = k;
                if (first) {
                    first = false;
                    continue;
                }
                while (k2 > 0) {
                    l2 = l2.next;
                    k2 --;
                }
                k2 = k;
            }
            l1 = l1.next;
            k1 --;
            // 快指针走到尾部
            if (l1 == null) {
                // 如果是长度不够那么返回head
                if (first) {
                    return head;
                }
                if (l2 == head && k1 == k) {
                    return head;
                }
                int step = k - k1;
                // 如果长度够
                while (step-- > 0) {
                    l2 = l2.next;
                }
            }
        }
        return l2;
    }
}
