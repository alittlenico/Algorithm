package com.lc.review.c7_binary_tree;

import com.lc.review.TreeNode;

import java.util.*;
/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 9:57
 */
public class LC94 {
    /**
     * 迭代中序遍历 自己维护一个栈
     * 每个节点只访问一次
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * morris解法:递归方法需要额外存储空间的原因就是我们要访问当前节点，必须先访问完左子树的节点。而树的访问是单向的，因此我们必须要
     * 使用额外的存储空间来存储节点。因此在访问的时候我们可以把找到在中序遍历下,当前节点的前驱节点,用它的前驱节点关联到当前节点。
     * 前置知识:1.中序遍历下,左子树的最右节点是当前节点的前驱节点，且该最右节点是孩子节点，它的右孩子为null。-> 可以用右孩子关联起来
     *         2.通过右孩子是否为null 判断当前是第一次访问还是第二次访问,第一次访问需要关联起来 第二次需要去除关联
     *
     *
     *         每个节点会访问两次
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            }else {
                pre = root.left;
                //找到最右节点
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                //第一次访问 关联root
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                }else {
                    //第二次访问 说明root的左子树已经访问完了
                    res.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        LC94 sol = new LC94();
        sol.inorderTraversal(root);
    }
}
