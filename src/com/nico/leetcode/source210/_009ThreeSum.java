package com.nico.leetcode.source210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c
 * in nums such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _009ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <3) return new ArrayList<>(0);
        List<List<Integer>> result = new ArrayList<>(nums.length/3);
        Arrays.sort(nums);
        //i < nums.length - 2 因为有三个数
        for(int i = 0;i < nums.length - 2;i++){//固定第一个数
            //第一个数 跳过相同的数
            if(i>0&&nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            int j = i+1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[j]+nums[k]>target) k--;
                else if(nums[j]+nums[k]<target)j++;
                else{
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;k--;
                    //对于第二个 和 第三个数 跳过相同的数 j > i + 1 j要从i+2开始才能去跳过，如果不判断
                    // 则j第一轮是与nums[i]比较
                    while(j<nums.length&&(j > i + 1)&&nums[j]==nums[j-1]) j++;
                    //要判断k不能是数组右边界 否则nums[k+1] 要报越界异常
                    while(j<k&&(k< nums.length -1)&&nums[k]==nums[k+1]) k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _009ThreeSum sol = new _009ThreeSum();
//        System.out.println(sol.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(sol.threeSum(new int[]{0,0,0}));
    }
}
