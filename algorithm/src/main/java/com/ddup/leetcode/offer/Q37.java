package com.ddup.leetcode.offer;

import com.ddup.leetcode.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *     请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/7/6 0006 20:48
 */
public class Q37 {
    public static void main(String[] args) {
        Q37 q37 = new Q37();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        String result = q37.serialize(root);
        System.out.println(result);
        TreeNode newRoot = q37.deserialize(result);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<List<Integer>> result = new ArrayList<>();
        addTreeNodeToList(root, result, 0);
        return result.stream()
                .filter(levelList -> levelList.stream().anyMatch(Objects::nonNull))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()).toString();
    }

    private void addTreeNodeToList(TreeNode root, List<List<Integer>> result, int deep) {
        List<Integer> currentLevel;
        if (deep == result.size()) {
            currentLevel = new ArrayList<>();
            result.add(deep, currentLevel);
        } else {
            currentLevel = result.get(deep);
        }
        if (root == null) {
            currentLevel.add(null);
            return;
        }
        currentLevel.add(root.val);
        addTreeNodeToList(root.left, result, deep + 1);
        addTreeNodeToList(root.right, result, deep + 1);
    }

    /**
     * 利用有数节点的队列出入对的方式来控制节点的位置
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> result = Arrays.stream(data.substring(1, data.length() - 1).split(","))
                .map(tmp -> {
                    tmp = tmp.trim();
                    if ("null".equals(tmp)) {
                        return null;
                    }
                    return Integer.valueOf(tmp);
                })
                .collect(Collectors.toList());
        if (result.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(result.get(0));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        for (int i = 1; i < result.size() - 1; i++) {
            Integer currentNodeValue = result.get(i);
            TreeNode node = queue.poll();
            if (currentNodeValue != null) {
                node.left = new TreeNode(currentNodeValue);
                queue.add(node.left);
            }
            i ++;
            Integer nextNodeValue = result.get(i);
            if (nextNodeValue != null) {
                node.right = new TreeNode(nextNodeValue);
                queue.add(node.right);
            }
        }
        return root;
    }

//    private void buildTreeNode(TreeNode root, List<Integer> result, int currentIndex) {
//        int leftIndex = (currentIndex << 1) + 1;
//        if (leftIndex > result.size() - 1) {
//            return;
//        }
//        int rightIndex = leftIndex + 1;
//        Integer leftValue = result.get(leftIndex);
//        root.left = Objects.isNull(leftValue) ? null : new TreeNode(leftValue);
//        Integer rightValue = result.get(rightIndex);
//        root.right = Objects.isNull(rightValue) ? null : new TreeNode(rightValue);
//        buildTreeNode(root.left, result, leftIndex);
//        buildTreeNode(root.right, result, rightIndex);
//    }
}
