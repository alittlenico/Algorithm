package leetcode.editor.cn;//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1280 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        //队列
        Deque<TreeNode> queen = new LinkedList<>();
        //特判
        if(root == null) {
            return ans;
        }
        queen.add(root);
        while(!queen.isEmpty()) {
            Deque<TreeNode> assitQueen = new LinkedList<>();
            //当前层队列元素全部出队 加入辅助队列
            while(!queen.isEmpty()) {
                assitQueen.offer(queen.poll());
            }
            //收集当前层元素 并把子节点加入队列中
            List<Integer> curList = new ArrayList<>();
            while(!assitQueen.isEmpty()) {
                TreeNode pollNode = assitQueen.poll();
                curList.add(pollNode.val);
                TreeNode pollNodeLeft = pollNode.left;
                TreeNode pollNodeRight = pollNode.right;
                if(pollNodeLeft != null) {
                    queen.offer(pollNodeLeft);
                }
                if(pollNodeRight != null) {
                    queen.offer(pollNodeRight);
                }
            }
            ans.add(curList);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
