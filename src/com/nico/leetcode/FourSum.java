package com.nico.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Notice that the solution set must not contain duplicate quadruplets.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [], target = 0
 * Output: []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) return result;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < len - 3;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int t1 = target - nums[i];
            //转换为a+b+c=t1的三数之和问题
            for(int j = i+1;j < nums.length - 2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int t2 = t1 - nums[j];
                int left = j+1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[left]+nums[right]>t2) right--;
                    else if(nums[left]+nums[right]<t2)left++;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;right--;
                        while(left < nums.length&&nums[left]==nums[left-1]) left++;
                        while(left < right && nums[right]==nums[right+1]) right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum sol = new FourSum();
        System.out.println(sol.fourSum(new int[]{1,0,-1,0,-2,2},0));
        System.out.println(sol.fourSum(new int[]{-2,-1,-1,1,1,2,2},0));
    }
}
