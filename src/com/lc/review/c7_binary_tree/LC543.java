package com.lc.review.c7_binary_tree;

import com.lc.review.TreeNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/9/12 21:24
 */
public class LC543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        int left = 0;
        int temp = 0;
        if(root.left != null) {
            left = dfs(root.left);
            temp = temp + left + 1;
        }
        int right = 0;
        if(root.right != null) {
            right = dfs(root.right);
            temp = temp + right + 1;
        }
        res = Math.max(res, temp);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        LC543 sol = new LC543();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        sol.diameterOfBinaryTree(root);
    }
}
