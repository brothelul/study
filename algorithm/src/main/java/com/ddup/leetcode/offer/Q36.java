package com.ddup.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *     我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/5 0005 20:28
 */
public class Q36 {
    public static void main(String[] args) {
        Node root = new Node(4);
//        root.left = new Node(2);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
//        root.right = new Node(5);
        Node head = treeToDoublyList(root);
    }

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> nodeList = new ArrayList<>();
        nodeToList(root, nodeList);
        for (int i = 0; i < nodeList.size(); i++) {
            Node current = nodeList.get(i);
            if (i == 0) {
                current.left = nodeList.get(nodeList.size() - 1);
            } else {
                current.left = nodeList.get(i - 1);
            }
            if (i == nodeList.size() - 1) {
                current.right = nodeList.get(0);
            } else {
                current.right = nodeList.get(i + 1);
            }
        }
        return nodeList.get(0);
    }

    private static void nodeToList(Node root, List<Node> nodeList) {
        if (root == null) {
            return;
        }
        nodeToList(root.left, nodeList);
        nodeList.add(root);
        nodeToList(root.right, nodeList);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
