package com.ddup.leetcode.other;

import com.ddup.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 *     给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * </p>
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @author chenglu
 * @date 2020/5/7
 */
public class CycleListCheck {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = head;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            if (nodeList.contains(head)) {
                return true;
            }
            nodeList.add(head);
            head = head.next;
        }
        return false;
    }
}
