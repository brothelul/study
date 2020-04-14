package com.ddup.leetcode.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p> 输入一个二叉树，以及指定一个层次，从右向左输出这一层的所有节点 </p>
 *
 * @author chenglu
 * @date 2020/4/14 0014 23:37
 */
public class LevelTreeResult {
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Tree tree = new Tree(2);
        tree.left = new Tree(3);
        tree.right = new Tree(5);
        tree.left.left = new Tree(3);
        tree.right.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right.right = new Tree(7);
        levelWord(tree, 3, 1);
        System.out.println(result);
    }

    private static void levelWord(Tree tree, int targetLevel, int currentLevel) {
        if (Objects.isNull(tree)) {
            return;
        }
        if (targetLevel == currentLevel) {
            result.add(tree.val);
            return;
        }
        currentLevel++;
        levelWord(tree.right, targetLevel, currentLevel);
        levelWord(tree.left, targetLevel, currentLevel);
    }
}
