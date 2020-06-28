package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *     从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/28
 */
public class Q32 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        System.out.println(Arrays.toString(levelOrder(root)));
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<List<Integer>> res = new ArrayList<>();
        convert(res, root, 0);
        return res.stream()
                .flatMap(Collection::stream)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void convert(List<List<Integer>> res, TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (res.size() == deep) {
            List<Integer> deepList = new ArrayList<>();
            deepList.add(root.val);
            res.add(deep, deepList);
        } else {
            List<Integer> deepList = res.get(deep);
            deepList.add(root.val);
        }
        convert(res, root.left, deep + 1);
        convert(res, root.right, deep + 1);
    }
}
