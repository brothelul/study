package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

/**
 * <p>
 *     请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/21 0021 16:29
 */
public class Q27 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(1);
        root = mirrorTree(root);
    }

    public static TreeNode mirrorTree(TreeNode root) {
        doMirrorTree(root);
        return root;
    }

    private static void doMirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        doMirrorTree(root.right);
        doMirrorTree(root.left);
    }
}
