package leetcode.editor.cn;//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1542 👎 0


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
class Solution105 {
    int len;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //快速从中序遍历中找出左右子树
        map = new HashMap<>();
        len = inorder.length;
        for(int i =0;i < len; ++i ) {
            map.put(inorder[i], i);
        }
        return recursiveBuildTree(preorder,0,len-1,
                inorder,0,len-1);
    }

    public TreeNode recursiveBuildTree(int[] preorder,int preL, int preR,
                                       int[] inorder,int inL,int inR) {
        //base case 当前子树只有一个节点
        TreeNode root = new TreeNode(preorder[preL]);
        if(preL == preR) {
            return root;
        }
        int border = map.get(preorder[preL]);
        //左子树节点个数
        int len = border - inL;
        //右子树节点个数
        int rLen = inR - border;
        //左子树前序区间
        int[] lPre = new int[] {preL+1,preL+len};
        //右子树的前序区间
        int[] rPre = new int[] {preL+len+1,preR};
        //左子树的中序区间
        int[] lIn = new int[] {inL, border - 1};
        //右子树的中序区间
        int[] rIn = new int[] {border + 1,inR};
        if(len > 0) {
            root.left = recursiveBuildTree(preorder,lPre[0],lPre[1],
                    inorder,lIn[0],lIn[1]);
        }
        if(rLen > 0) {
            root.right = recursiveBuildTree(preorder,rPre[0],rPre[1],
                    inorder,rIn[0],rIn[1]);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
