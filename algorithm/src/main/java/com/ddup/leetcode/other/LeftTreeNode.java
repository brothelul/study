package com.ddup.leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p> 给定一个二叉树，返回二叉树每层的最左的值。 </p>
 *
 * @author chenglu
 * @date 2020/4/1
 */
public class LeftTreeNode {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(3);
        tree.right = new Tree(4);
        Tree right = tree.right;
        right.left = new Tree(7);
        right.right = new Tree(5);
        listTree(1, tree);
        System.out.println(map);
    }

    private static void listTree(int i, Tree tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        if (Objects.isNull(map.get(i))) {
            map.put(i, tree.val);
        }
        i++;
        listTree(i, tree.left);
        listTree(i, tree.right);
    }
}


class Tree {
    Tree left;
    Tree right;
    int val;

    public Tree(int val) {
        this.val = val;
    }
}
