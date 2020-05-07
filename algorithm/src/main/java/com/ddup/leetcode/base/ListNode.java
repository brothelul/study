package com.ddup.leetcode.base;

import java.util.Objects;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2020/5/7
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { this.val = x; }

    @Override
    public String toString() {
        ListNode listNode = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (Objects.nonNull(listNode)) {
            stringBuilder.append(listNode.val);
            if (Objects.nonNull(listNode.next)) {
                stringBuilder.append(" => ");
            }
            listNode = listNode.next;
        }
        return stringBuilder.toString();
    }
}
