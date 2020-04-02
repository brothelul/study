package com.ddup.leetcode.other;

import java.util.Objects;

/**
 * <p> 二叉树镜像 </p>
 *
 * @author chenglu
 * @date 2020/4/2 0002 22:28
 */
public class ImageTree {
    private static Tree temp;
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(3);
        root.right = new Tree(4);
        root.left.left = new Tree(2);
        imageTree(root);
    }

    private static void imageTree(Tree tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        imageTree(tree.left);
        imageTree(tree.right);
    }
}
