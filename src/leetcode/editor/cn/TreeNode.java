package leetcode.editor.cn;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/01/22/19:09
 * @Description:
 */
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
