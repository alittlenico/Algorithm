package leetcode.editor.cn;//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1203 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

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
class Solution1 {
    int res = 0;
    int t;
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        if(root == null) return 0;
        bfs(root);
        return res;
    }

    void bfs(TreeNode node){//遍历所有节点 可采用任何方式
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(node);
        while(!queue.isEmpty()){//层级遍历 或称bfs
            TreeNode curNode = queue.remove();
            dfs2(curNode,curNode.val);
            if(curNode.left != null)
                queue.add(curNode.left);
            if(curNode.right != null)
                queue.add(curNode.right);
        }
    }

    /**
        求当前节点向下的路径数

     */
    void dfs2(TreeNode node,int val) {
        if(val == t) ++res;
        if(node.left != null)
            dfs2(node.left,val + node.left.val);
        if(node.right != null)
            dfs2(node.right,val + node.right.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
