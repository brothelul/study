package com.ddup.leetcode.stack.q173;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * <p> 二叉搜索树迭代器 </p>
 *  实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *  调用 next() 将返回二叉搜索树中的下一个最小的数。
 * @author chenglu
 * @date 2019/12/4
 */
public class Main {

}


/**
 *   Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class BSTIterator {

    List<Integer> arrays;
    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        arrays = new ArrayList<>();
        addToArray(root);
        arrays.sort(Integer::compareTo);
        iterator = arrays.iterator();
    }

    public void addToArray(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        arrays.add(treeNode.val);

        if (Objects.nonNull(treeNode.left)) {
            addToArray(treeNode.left);
        }
        if (Objects.nonNull(treeNode.right)) {
            addToArray(treeNode.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        int value = iterator.next();
        iterator.remove();
        return value;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
