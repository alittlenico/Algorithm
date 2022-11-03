package com.lc.tree;

import com.lc.review.TreeNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/3 9:15
 */
public class LC99 {
    TreeNode pre = null;
    TreeNode x = null;
    TreeNode y = null;
    int count = 2;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        swap(x,y);
        System.out.println(root);
    }

    public void inorder(TreeNode root) {
        if(root == null || count == 0) return;
        inorder(root.left);
        pre = pre == null ? root : pre;
        if(pre.val > root.val) {
            if(count == 2) {
                x = pre;
                y = root;
                --count;
            }else {
                y = root;
                --count;
            }
        }
        pre = root;
        inorder(root.right);
    }

    public void swap(TreeNode x,TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    public static void main(String[] args) {
        LC99 sol = new LC99();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        sol.recoverTree(root);
    }
}
