package com.ddup.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结
 * 点，请删除该链表中重复的结点，重复
 * 的结点不保留，返回链表头指针。例
 * 如，链表1－＞2－＞3－＞3－＞4－4－＞5处理后为
 * 1->2->5
 * </p>
 *
 * @author chenglu
 * @date 2020/4/15
 */
public class LinkDuplicateRemove {
    static List<Integer> duplicateNumbers = new ArrayList<>();
    public static void main(String[] args) {
        Link root = new Link(1);
        root.next = new Link(2);
        root.next.next = new Link(3);
        root.next.next.next = new Link(3);
        root.next.next.next.next = new Link(4);
        root.next.next.next.next.next = new Link(4);
        root.next.next.next.next.next.next = new Link(5);
        System.out.println(removeDuplicate(root).toString(duplicateNumbers));
    }

    private static Link removeDuplicate(Link link) {
        Link current = link;
        Link nextNode = current;
        while (current != null) {
            if (nextNode.val != current.val) {
                nextNode.next = new Link(current.val);
                nextNode = nextNode.next;
            } else {
                if (nextNode != current) {
                    duplicateNumbers.add(current.val);
                }
            }
            current = current.next;
        }
        return link;
    }
}

class Link {
    Link next;
    int val;

    public Link(int val) {
        this.val = val;
    }

    public Link(Link next, int val) {
        this.next = next;
        this.val = val;
    }

    public String toString(List<Integer> duplicateNumbers) {
        StringBuilder sb = new StringBuilder();
        Link current = this;
        while (current != null) {
            if (duplicateNumbers.contains(current.val)) {
                current = current.next;
                continue;
            }
            if (current.next == null) {
                sb.append(current.val);
            } else {
                sb.append(current.val + " -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
