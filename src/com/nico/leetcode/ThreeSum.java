package com.nico.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <3) return result;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            int j = i+1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[j]+nums[k]>target) k--;
                else if(nums[j]+nums[k]<target)j++;
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;k--;
                    while(j<nums.length&&nums[j]==nums[j-1]) j++;
                    while(j<k&&nums[k]==nums[k+1]) k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
//        System.out.println(sol.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(sol.threeSum(new int[]{0,0,0}));
    }
}
