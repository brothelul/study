package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/28 0028 23:01
 */
public class Q33_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        convertTree(res, root, 0);
        return res;
    }

    private static void convertTree(List<List<Integer>> res, TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (res.size() == deep) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(root.val);
            res.add(deep, tempList);
        } else {
            List<Integer> tempList = res.get(deep);
            tempList.add(root.val);
        }
        convertTree(res, root.left, deep + 1);
        convertTree(res, root.right, deep + 1);
    }
}
