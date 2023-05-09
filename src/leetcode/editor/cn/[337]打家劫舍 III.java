package leetcode.editor.cn;//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
//
// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接
//相连的房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1318 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
class Solution337 {

    public int rob(TreeNode root) {
        int[] val = dfs(root);
        return Math.max(val[0], val[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

//    public int rob(TreeNode root) {
//        int[] res = postOrderedDfs(root);
//        return Math.max(res[0], res[1]);
//    }
//
//   public int[] postOrderedDfs(TreeNode root) {
//        if (root == null) {
//            return new int[2];
//        }
//        //res[0] 当前节点不选 res[1]当前节点选择
//        int[] res = new int[2];
//        int[] resLeft = postOrderedDfs(root.left);
//        int[] resRight = postOrderedDfs(root.right);
//        //当前节点不偷：左孩子能偷到的最多钱 + 右孩子能偷到的最多钱
//        res[0] = Math.max(resLeft[0], resLeft[1]) + Math.max(resRight[0], resRight[1]);
//        res[1] = resLeft[0] + resRight[0] + root.val;
//        return res;
//   }
}
//leetcode submit region end(Prohibit modification and deletion)
