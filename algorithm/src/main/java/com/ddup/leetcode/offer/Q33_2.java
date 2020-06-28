package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/29 0029 0:04
 */
public class Q33_2 {
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
        for (int i = 0; i < res.size(); i++) {
            if ((i & 1) == 1) {
                List<Integer> temp = res.get(i);
                Collections.reverse(temp);
            }
        }
        return res;
    }

    private static void convertTree(List<List<Integer>> res, TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep == res.size()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(deep, temp);
        } else {
            List<Integer> temp = res.get(deep);
            temp.add(root.val);
        }
        convertTree(res, root.left, deep + 1);
        convertTree(res, root.right, deep + 1);
    }
}
