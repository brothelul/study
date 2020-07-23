package com.ddup.leetcode.offer;

import com.ddup.leetcode.base.ListNode;

import java.util.Objects;

/**
 * <p>
 *     输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/23 0023 22:43
 */
public class Q52 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        System.out.println(getIntersectionNode1(l1, l2));
    }

    /**
     * 链表长度对比
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        int l1Length = 0, l2Length = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1Length++;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Length++;
                l2 = l2.next;
            }
        }
        ListNode first = null;
        l1 = headA;
        l2 = headB;
        if (l1Length > l2Length) {
            int gap = l1Length - l2Length;
            for (int i = 0; i < l1Length; i++) {
                if (i > gap - 1) {
                    if (l2.val == l1.val) {
                        first = l1;
                        break;
                    }
                    l2 = l2.next;
                }
                l1 = l1.next;
            }
        } else {
            int gap = l2Length - l1Length;
            for (int i = 0; i < l2Length; i++) {
                if (i > gap - 1) {
                    if (l2.val == l1.val) {
                        first = l2;
                        break;
                    }
                    l1 = l1.next;
                }
                l2 = l2.next;
            }
        }
        return first;
    }

    /**
     * 双指针，1个走A一个走B到达终点后相互交换，这样连个得长度就是相同的了
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        // 遇到两次链表尾部则结束循环
        int i = 2;
        ListNode first = null;
        while (i > 0) {
            if (l1.val == l2.val) {
                first = Objects.nonNull(first) ? first : l1;
            } else {
                first = null;
            }
            if (l1.next == null) {
                l1 = headB;
                i --;
            } else {
                l1 = l1.next;
            }
            if (l2.next == null) {
                l2 = headA;
            } else {
                l2 = l2.next;
            }
        }
        return first;
    }
}
