package com.ddup.leetcode.stack.q94;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 二叉树的中序遍历 </p>
 *
 * @author chenglu
 * @date 2019/10/24
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
       // System.out.println(inorderTraversal(treeNode));
    }

    List<Integer> orders = new ArrayList<Integer>();

    public  List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return orders;
        }
        inorderTraversal(root.left);
        orders.add(root.val);
        inorderTraversal(root.right);
        return orders;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
