package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

/**
 * <p>
 *     输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/18 0018 23:10
 */
public class Q26 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(7);
        a.left.left.left = new TreeNode(8);
        a.left.left.right = new TreeNode(9);
        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(8);
        b.right = new TreeNode(9);
        System.out.println(isSubStructure(a, b));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (doIsSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private static boolean doIsSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return doIsSubStructure(A.left, B.left) && doIsSubStructure(A.right, B.right);
    }
}
