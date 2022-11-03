package com.lc.review.c7_binary_tree;

import com.lc.review.TreeNode;

import java.util.Deque;
import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/18 21:10
 */
public class LC103 {
    int layer = 0;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList();
        queue.offer(root);
        while(queue.size() > 0) {
            List<TreeNode> temp = new ArrayList<>();
            while(queue.size() > 0) {
                temp.add(queue.poll());
            }
            List<Integer> tempV = new ArrayList<>();
            for(int i = 0;i < temp.size();++i) {
                tempV.add(temp.get(i).val);
                queue.offer(temp.get(i).left);
                queue.offer(temp.get(i).right);
            }
            if(layer % 2 != 0) {
                for(int i = 0;i < tempV.size() / 2;++i) {
                    Collections.swap(tempV,i, tempV.size() - 1 - i);
                }
            }
            res.add(tempV);
            ++layer;
        }
        return res;
    }

    public static void main(String[] args) {
        LC103 sol = new LC103();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        sol.zigzagLevelOrder(root);
    }
}
