package com.nico.leetcode.source210;

public class _21FindTheFirstAndLastPostionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;int right = nums.length-1;
        int mid = -1;
//        int[] result = new int[2];
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                int start = mid;
                int end = mid;
                int i = mid;
                for(;i >= 0;i--){
                    if(nums[i] == target){ continue;}
                    else{
                        start = i + 1;
                        break;
                    }
                }
                if(i == -1){
                    start = i + 1;
                }
                for(i = mid;i < nums.length;i++){
                    if(nums[i] == target){ continue;}
                    else{
                        end = i - 1;
                        break;
                    }
                }
                if(i == nums.length){
                    end = i - 1;
                }
                return new int[]{start,end};
            }else{
                if(nums[mid] > target){
                    right = mid -1;
                }else{
                    left = mid + 1;
                }

            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        _21FindTheFirstAndLastPostionOfElementInSortedArray sol = new _21FindTheFirstAndLastPostionOfElementInSortedArray();
        int[] result = sol.searchRange(new int[]{2,2},2);
        System.out.println(result);
    }
}
