package com.nico;

public class Solution {
    public static void main(String[] args) {
        //16,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]

//        int[][] array = {};
//        if(array.length!=0){
//            int row = array.length;
//            int column = array[0].length;
//            for(int i=0;i<row;i++){
//                for(int j=0;j<column;j++)
//                    System.out.print(array[i][j]+"\t");
//                System.out.println();
//            }
//            boolean result = Find(16,array);
//            System.out.println(result);
//        }
//        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println(Find1(16,array));

        Solution sol = new Solution();
        int[] nums = {1,4,4};
        int target = 4;

        System.out.println(sol.shortestSubArraySumIsTarget(nums, target));

    }
    public static boolean Find(int target, int[][] array) {//暴力解
        //判空
        if(array.length==0||array[0].length==0) return false;
        int row = array.length;
        int column = array[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++)
                if(target==array[i][j])
                    return true;
        }
        return false;
    }

    public static boolean Find1(int target,int[][] array){//二分法
        if(array.length==0||array[0].length==0) return false;
        int row = array.length;
        int column = array[0].length;
        int i=0;
        int j=column-1;
        while (j>=0&&i<=(row-1)){
            int val = array[i][j];
            if(target == val) return true;
            else if(target < val)
                j--;
            else
                i++;
        }
        return false;
    }


    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * 提示：
     *      1 <= target <= \(10^9\)
     *      1 <= nums.length <= \(10^5\)
     *      1 <= nums[i] <= \(10^5\)
     */
    public int shortestSubArraySumIsTarget(int[] nums, int target) {
        int left = 0,right = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            ++right;
            if (sum >= target) {
                res = Math.min(res, right - left);
            }
            while (sum >= target) {
                sum -= nums[left];
                ++left;
                if (sum >= target) {
                    res = Math.min(res, right - left);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * <p>
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * <p>
     * 示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     */
    public boolean checkPosIsAccess(int[] nums) {
        //最远可以到达的位置
        int maxJump = 0;
        int len = nums.length;
        for (int i = 0;i < len;++i) {
            //当前位置可达
            if (i <= maxJump) {
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            if (maxJump >= len - 1) {
                return true;
            }
        }
        return false;
    }




















}
