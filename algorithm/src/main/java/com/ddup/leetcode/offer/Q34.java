package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * @author chenglu
 * @date 2020/6/30 0030 23:15
 */
public class Q34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> publicRes = new ArrayList<>();
        doPathSum(root, sum, res, publicRes);
        return res;
    }

    private static void doPathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> publicRes) {
        if (root == null) {
            return;
        }
        publicRes.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            List<Integer> resTemp = new ArrayList<>(publicRes);
            res.add(resTemp);
            publicRes.remove(publicRes.size() - 1);
            return;
        }
        doPathSum(root.left, sum, res, publicRes);
        doPathSum(root.right, sum, res, publicRes);
        publicRes.remove(publicRes.size() - 1);
    }
}
