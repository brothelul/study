package com.ddup.leetcode.stack.e0;

/**
 * <p> 给定一个数组构造二叉树 </p>
 *
 * @author chenglu
 * @date 2019/10/24
 */
public class Main {
    public static void main(String[] args) {
        Integer[] values = new Integer[] {1, null, 3, 4, 5, null, 6, 7};
    }

    public TreeNode initTreeNode(Integer[] values) {
        return null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(int x) { val = x; }
}
