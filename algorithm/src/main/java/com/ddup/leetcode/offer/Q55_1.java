package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

/**
 * <p>
 *     输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/27
 */
public class Q55_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(maxDepth(root));
    }

    static int maxDeep = 0;

    public static int maxDepth(TreeNode root) {
        iteratorTree(root, 1);
        return maxDeep;
    }

    private static void iteratorTree(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep > maxDeep) {
            maxDeep = deep;
        }
        iteratorTree(root.left, deep + 1);
        iteratorTree(root.right, deep + 1);
    }
}
