package com.lc.tree;

import com.lc.review.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/3 10:05
 */
class Solution {
    //中序遍历 迭代写法
    public void inoder(TreeNode root) {
        //辅助栈
        Deque<TreeNode> stack = new ArrayDeque<>();
        //前节点
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null) {
                // todo-ly 2022/10/3 10:19
            }
            pre = root;
            root = root.right;
        }
    }
}
