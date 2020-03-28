package com.ddup.leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 给定两个非空链表，每一个节点代表一个数字0-9，单个链表从左往右是由高位到低位组成的一个数，现在需要将两个链表表示的数相加并且以链表形式返回。
 * 举例：Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 * 可不可以不采用逆序的方式实现
 *
 * 作者：zhouwaiqiang
 * 链接：https://www.jianshu.com/p/6796047d9bb4
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author chenglu
 * @date 2020/3/26
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        System.out.println(addLinkNode(l1, l2));
    }

    private static ListNode addLinkNode(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        while (Objects.nonNull(l1)) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        List<Integer> list2 = new ArrayList<>();
        while (Objects.nonNull(l2)) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        AtomicReference<Integer> i = new AtomicReference<>(Math.toIntExact((long) Math.pow(10, list1.size()-1)));
        Integer v1 = Math.toIntExact(list1.stream().mapToInt(in -> in * i.getAndUpdate(v -> v / 10)).sum());
        AtomicReference<Integer> j = new AtomicReference<>(Math.toIntExact((long) Math.pow(10, list2.size()-1)));
        Integer v2 = Math.toIntExact(list2.stream().mapToInt(in -> in * j.getAndUpdate(v -> v / 10)).sum());
        Integer sum = v1 + v2;
        ListNode result = new ListNode(sum % 10);
        ListNode current =result;
        while (sum > 0) {
            sum = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { this.val = x; }

    @Override
    public String toString() {
        ListNode listNode = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (Objects.nonNull(listNode.next)) {
            stringBuilder.append(listNode.val + " => ");
            listNode = listNode.next;
        }
        return stringBuilder.toString();
    }
}
