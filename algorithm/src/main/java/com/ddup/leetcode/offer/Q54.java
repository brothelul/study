package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *     给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/25
 */
public class Q54 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        System.out.println(kthLargest(treeNode, 3));
    }

    /**
     * 右节点 -> 根节点 -> 左节点顺序遍历，抛异常方式
     * @param root
     * @param k
     * @return
     */
    public static int kthLargest(TreeNode root, int k) {
        try {
            iteratorTree(root, k, new AtomicInteger(0));
        } catch (Exception e) {
            return Integer.valueOf(e.getMessage());
        }
        return 0;
    }

    private static void iteratorTree(TreeNode root, int k, AtomicInteger idx) {
        if (root == null) {
            return;
        }
        iteratorTree(root.right, k, idx);
        if (k == idx.incrementAndGet()) {
            throw new RuntimeException("" + root.val);
        }
        iteratorTree(root.left, k, idx);
    }

    /**
     * 全局变量方式
     */
    int res, k;
    public int kthLargest1(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
