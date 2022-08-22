package com.lc.review.c7_binary_tree;


import com.lc.review.TreeNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 22:35
 */
public class LC98 {
    public boolean isValidBST(TreeNode root) {
        long low = Long.MIN_VALUE;
        long up = Long.MAX_VALUE;
        return valid(root, low, up);
    }

    public boolean valid(TreeNode root, long low, long up) {
        if(root == null) return true;
        if(root.val <= low || root.val >= up) return false;
        return valid(root.left,low, root.val) && valid(root.right,root.val,up);
    }


}
