package com.ddup.leetcode.offer;

/**
 * <p>
 *
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 *  如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      4
 *     / \
 *    2   6
 *   / \  / \
 *  1   3 5  7
 *            \
 *            8
 * 示例 1：
 *
 * 输入: [1,6,3,2,5,7,8,4]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,5,8,7,6,4]
 * 输出: true
 *  
 *
 * 提示：
 *
 * 数组长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author chenglu
 * @date 2020/6/29 0029 23:42
 */
public class Q33 {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[] {5, 4, 3, 2, 1}));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return doVerify(postorder, 0, postorder.length - 1);
    }

    private static boolean doVerify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int p = start;
        while(postorder[p] < root) {
            p++;
        }
        int m = p;
        while(postorder[p] > root) {
            p++;
        }
        return p == end && doVerify(postorder, start, m - 1)
                && doVerify(postorder, m, end - 1);
    }
}
