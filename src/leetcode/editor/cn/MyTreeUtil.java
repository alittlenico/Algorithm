package leetcode.editor.cn;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2023/4/28 16:09
 */
public class MyTreeUtil {

    public static TreeNode restoreTreeFromLevelOrder(String[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(levelOrder[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < levelOrder.length && !levelOrder[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(levelOrder[i]));
                queue.offer(node.left);
            }
            i++;
            if (i < levelOrder.length && !levelOrder[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(levelOrder[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }


    public static List<String> levelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String[] strs = {"1", "2", "3", "4", "5"};
        TreeNode treeNode = restoreTreeFromLevelOrder(strs);
        List<String> levelOrderList = levelOrder(treeNode);
        levelOrderList.stream().forEach(System.out::println);

    }
}
