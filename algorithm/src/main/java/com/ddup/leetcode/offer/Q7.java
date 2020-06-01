package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

import java.util.Arrays;

/**
 * <p>
 *     输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/1 0001 22:56
 */
public class Q7 {
    public static void main(String[] args) {
        TreeNode tree = buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        System.out.println(tree);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int first = preorder[0];
        int tag = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (first == inorder[i]) {
                tag = i;
                break;
            }
        }
        TreeNode root = new TreeNode(first);
        if (tag >= 1) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, tag + 1),
                    Arrays.copyOfRange(inorder, 0, tag));
        }
        if (tag < inorder.length - 1) {
            root.right = buildTree(Arrays.copyOfRange(preorder, tag + 1, preorder.length ),
                    Arrays.copyOfRange(inorder, tag + 1, inorder.length));
        }
        return root;
    }
}
