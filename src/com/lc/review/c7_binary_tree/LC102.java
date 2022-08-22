package com.lc.review.c7_binary_tree;

import com.lc.review.TreeNode;

import java.util.*;
/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 22:48
 */
public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> assistQueue = new LinkedList<>();
        List<Integer> temp = new ArrayList<Integer>();
        queue.add(root);
        while(queue.size() > 0) {
            while(queue.size() > 0) {
                assistQueue.add(queue.poll());
            }
            while(assistQueue.size() > 0) {
                TreeNode poll = assistQueue.poll();
                temp.add(poll.val);
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(new ArrayList<Integer>(temp));
            temp.clear();
        }
        return res;
    }
}
