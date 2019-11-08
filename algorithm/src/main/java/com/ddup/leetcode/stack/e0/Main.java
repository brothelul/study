package com.ddup.leetcode.stack.e0;

/**
 * <p> 给定一个数组构造二叉树 </p>
 *
 * @author chenglu
 * @date 2019/10/24
 */
public class Main {
    public static void main(String[] args) {
        //Integer[] values = new Integer[] {1, null, 3, 4, 5, null, 6, 7};
        TreeNode pTreeNode = new TreeNode(1);
        TreeNode treeNode = new TreeNode(3);
        pTreeNode.left = treeNode;
        treeNode = new TreeNode(2);
        pTreeNode.left = treeNode;
        treeNode = null;
        System.out.println(pTreeNode.left.val);
    }

    public TreeNode initTreeNode(Integer[] values) {

        return null;
    }

}

class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(int x) { val = x; }
}
