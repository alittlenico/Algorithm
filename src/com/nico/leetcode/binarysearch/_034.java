package com.nico.leetcode.binarysearch;

public class _034 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return new int[]{-1,-1};
        int lo = 0;int hi = len - 1;
        int mid;
        while(lo <= hi){
            if(nums[lo] == nums[hi]){
                if(nums[lo] == target) return new int[]{lo,hi};
                else return new int[]{-1,-1};
            }
            mid = (lo + hi) / 2;
            if(nums[mid] == target){
                int leftIdx = mid;int rightIdx = mid;
                while(leftIdx >= lo && nums[leftIdx] == target){--leftIdx;}
                leftIdx = leftIdx < lo ? lo : leftIdx + 1;
                while(rightIdx <= hi && nums[rightIdx] == target){++rightIdx;}
                rightIdx = rightIdx > hi ? hi : rightIdx - 1;
                return new int[]{leftIdx,rightIdx};
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        _034 sol = new _034();
        int [] arr = sol.searchRange(new int[]{5,7,7,8,8,10},8);
        for(int a : arr) System.out.println(a + " ");
    }
}
