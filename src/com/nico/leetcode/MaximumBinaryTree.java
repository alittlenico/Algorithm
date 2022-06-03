package com.nico.leetcode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums,0,nums.length-1);
    }

    public TreeNode maxTree(int[] nums,int left,int right){
        if(left > right) return null;
        else{
            //bond为当前数组中最大值的索引
            int bond = findMax(nums, left, right);
            TreeNode root = new TreeNode(nums[bond]);
            root.left = maxTree(nums, left, bond - 1);
            root.right = maxTree(nums, bond + 1, right);
            return root;
        }
    }

    //返回在当前区间的最大值下标
    public int findMax(int[] nums,int left,int right){
        int max = nums[left];
        int index = left;
        for(int i = left+1;i <= right;i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MaximumBinaryTree sol = new MaximumBinaryTree();
        TreeNode node = sol.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(node);
    }
}
