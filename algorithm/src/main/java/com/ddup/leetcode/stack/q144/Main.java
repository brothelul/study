package com.ddup.leetcode.stack.q144;

import com.ddup.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/12/4
 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
    }

    List<Integer> values = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return values;
        }
        values.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return values;
    }
}


