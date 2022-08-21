package com.lc.review;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/01/22/19:09
 * @Description:
 */
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
