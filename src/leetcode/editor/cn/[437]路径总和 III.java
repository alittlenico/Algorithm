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
import java.util.LinkedList;

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
class Solution437 {

    int t;
    int res;

    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        if (root == null) return 0;
        bfs(root);
        return res;
    }

    /**
     * 层序遍历所有节点
     * @param root
     */
    void bfs(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            dfs(node, node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
    }

    /**
     * 向下深度遍历到当前节点时 累积的值
     * @param root
     * @param sum
     */
    void dfs(TreeNode root,long sum) {
        if (sum == t) ++res;
        if (root.left != null)
            dfs(root.left, sum + root.left.val);
        if (root.right != null)
            dfs(root.right, sum + root.right.val);
    }


    public static void main(String[] args) {

//        Solution sol = new Solution();
//        String[] strs = {"1000000000", "1000000000", "null", "294967296", "null", "1000000000", "null", "1000000000", "null", "1000000000"};
//        TreeNode treeNode = MyTreeUtil.restoreTreeFromLevelOrder(strs);
//        sol.pathSum(treeNode, 0);
//        Deque<Integer> queue = new LinkedList<>();
//        for (int i = 0;i < 5;i++) {
//            queue.addFirst(i);
//        }
//        while (!queue.isEmpty()) {
//            Integer integer = queue.removeLast();
//            System.out.println(integer);
//        }
    }

//    int res = 0;
//    int t;
//    public int pathSum(TreeNode root, int targetSum) {
//        t = targetSum;
//        if(root == null) return 0;
//        bfs(root);
//        return res;
//    }
//
//    void bfs(TreeNode node){//遍历所有节点 可采用任何方式
//        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
//        queue.add(node);
//        while(!queue.isEmpty()){//层级遍历 或称bfs
//            TreeNode curNode = queue.remove();
//            dfs2(curNode,curNode.val);
//            if(curNode.left != null)
//                queue.add(curNode.left);
//            if(curNode.right != null)
//                queue.add(curNode.right);
//        }
//    }
//
//    /**
//        求当前节点向下的路径数
//
//     */
//    void dfs2(TreeNode node,int val) {
//        if(val == t) ++res;
//        if(node.left != null)
//            dfs2(node.left,val + node.left.val);
//        if(node.right != null)
//            dfs2(node.right,val + node.right.val);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
