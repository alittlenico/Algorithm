package com.nico.leetcode.source210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target? Find all unique quadruplets in the
 * array which gives the sum of target.
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
 */
public class _012FourSum {

    public List<List<Integer>> fourSum2Test(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>(nums.length/4);
        if(nums == null || nums.length < 4) return new ArrayList<>(0);
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < len - 3;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //过滤掉在当前i条件下 必定无解的情况
            if(nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target){
                continue;
            }
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            int t1 = target - nums[i];
            //转换为a+b+c=t1的三数之和问题
            for(int j = i+1;j < nums.length - 2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                if(nums[i] + nums[len-3] + nums[len-2] + nums[len-1] <target){
                    continue;
                }
                if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                    break;
                }
                int left = j+1;
                int right = len - 1;
                while(left < right){
                    if(nums[i] + nums[j] + nums[left] + nums[right] == target){
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else{
                        if(nums[i] + nums[j] + nums[left] + nums[right] > target)                                  right--;
                        else if(nums[i] + nums[j] + nums[left] + nums[right] < target)                              left++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 大佬的题解
     * 2ms 100%
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len-3;i++){
            if(i>0&& nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            for(int j=i+1;j<len-2;j++){
                if(j-i>1&&nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[i]+nums[j]+nums[len-1]+nums[len-2]<target){
                    continue;
                }
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                int left = j+1;
                int right = len-1;
                while(left<right){
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while(left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                        while(left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(nums[i]+nums[j]+nums[left]+nums[right]>target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(nums.length/4);
        if(nums == null || nums.length < 4) return new ArrayList<>(0);
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
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;right--;
                        while(left < len&&(left > j+1)&&nums[left]==nums[left-1]) left++;
                        while(left < right &&(right < len -1) && nums[right]==nums[right+1]) right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _012FourSum sol = new _012FourSum();
        System.out.println(sol.fourSum2(new int[]{1,0,-1,0,-2,2},0));
        System.out.println(sol.fourSum2(new int[]{-2,-1,-1,1,1,2,2},0));
    }
}
