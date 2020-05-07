package com.ddup.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * </p>
 *输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author chenglu
 * @date 2020/5/6
 */
public class ValidSearchTree {
    public static void main(String[] args) {
        Tree root = new Tree(8);
        root.left = new Tree(7);
        root.right = new Tree(9);
        root.left.left = new Tree(2);
        root.left.right = new Tree(6);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(Tree root) {
        List<Integer> treeVals = new ArrayList<>();
        listTree(root, treeVals);
        if (treeVals.isEmpty()) {
            return true;
        }
        for (int i = 0; i < treeVals.size()-1; i++) {
            if (treeVals.get(i) >= treeVals.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static void listTree(Tree root, List<Integer> treeVals) {
        if (root == null) {
            return;
        }
        listTree(root.left, treeVals);
        treeVals.add(root.val);
        listTree(root.right, treeVals);
    }
}
