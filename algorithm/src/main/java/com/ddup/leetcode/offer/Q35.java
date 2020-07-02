package com.ddup.leetcode.offer;

import com.ddup.leetcode.base.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *     还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/2 0002 23:00
 */
public class Q35 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.random = new Node(1);
        head.next.next = new Node(8);
        head.next.random = head;
        Node newHead = copyRandomList(head);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Map<Node, Node> container = new HashMap<>(16);
        container.put(head, newHead);
        doCopyRandomList(head, container, newHead);
        return newHead;
    }

    private static void doCopyRandomList(Node head, Map<Node, Node> container, Node newHead) {
        container.put(head, newHead);
        if (head.random == null) {
            newHead.random = null;
        } else {
            Node random = container.get(head.random);
            if (random == null) {
                random =  new Node(0);
                container.put(head.random,  random);
            }
            newHead.random = random;
        }
        if (head.next == null) {
            return;
        }
        Node newNext = container.get(head.next);
        if (newNext == null) {
            newNext = new Node(head.next.val);
            container.put(head.next, newNext);
        } else {
            newNext.val = head.next.val;
        }
        newHead.next = newNext;
        doCopyRandomList(head.next, container, newHead.next);
    }
}
