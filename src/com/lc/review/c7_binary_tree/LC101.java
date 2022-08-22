package com.lc.review.c7_binary_tree;

import com.lc.review.TreeNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 22:37
 */
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
