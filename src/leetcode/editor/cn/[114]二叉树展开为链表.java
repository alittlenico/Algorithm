package leetcode.editor.cn;//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1144 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
class Solution114 {
    // todo-ly 2023/4/25 11:29
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    // todo-ly 2023/4/25 11:04
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        List<TreeNode> list = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode top = stack.poll();
//            list.add(top);
//            if (top.right != null) {
//                stack.push(top.right);
//            }
//            if (top.left != null) {
//                stack.push(top.left);
//            }
//        }
//        for (int i = 0;i < list.size() - 1;++i) {
//            TreeNode treeNode = list.get(i);
//            treeNode.left = null;
//            treeNode.right = list.get(i+1);
//        }
//        list.get(list.size() - 1).left = null;
//        list.get(list.size() - 1).right = null;
//    }

//    public void flatten(TreeNode root) {
//        if(root == null) {
//            return;
//        }
//        List<TreeNode> list = new ArrayList<>();
//        preorder(root,list);
//        TreeNode cur = root;
//        cur.left = null;
//        for(int i = 1;i < list.size(); ++i) {
//            TreeNode node = list.get(i);
//            node.left = null;
//            cur.right = node;
//            cur = cur.right;
//        }
//    }
//
//    public void preorder(TreeNode root, List<TreeNode> list) {
//        Deque<TreeNode> stack = new LinkedList<>();
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
