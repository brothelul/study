package com.ddup.leetcode.base;

/**
 * <p> 双节点 </p>
 *
 * @author chenglu
 * @date 2020/7/2 0002 23:01
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
