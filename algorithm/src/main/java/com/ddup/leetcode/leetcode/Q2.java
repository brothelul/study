package com.ddup.leetcode.leetcode;

import com.ddup.leetcode.base.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenglu
 * @date 2021-06-14 23:06
 */
public class Q2 {
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        System.out.println(addTwoNumbers(l1, l2));
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        boolean addBit = false;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (!addBit) {
                    ListNode temp = current;
                    current = new ListNode(l2.val);
                    temp.next = current;
                } else {
                    addBit = (((l2.val + 1) / 10)  > 0);
                    ListNode temp = current;
                    current = new ListNode((l2.val + 1) % 10);
                    temp.next = current;
                }
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                if (!addBit) {
                    ListNode temp = current;
                    current = new ListNode(l1.val);
                    temp.next = current;
                } else {
                    addBit = (((l1.val + 1) / 10)  >  0);
                    ListNode temp = current;
                    current = new ListNode((l1.val + 1) % 10);
                    temp.next = current;
                }
                l1 = l1.next;
                continue;
            }
            int val = l1.val + l2.val + (addBit ? 1 : 0);
            addBit = ((val / 10) > 0);
            if (head == null) {
                head = new ListNode(val % 10);
                current = head;
            } else {
                ListNode temp = current;
                current = new ListNode(val % 10);
                temp.next = current;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (addBit) {
            ListNode temp = current;
            current = new ListNode(1);
            temp.next = current;
        }
        return head;
    }
    
}
