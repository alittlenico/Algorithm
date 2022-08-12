package com.lc.review.c4_array.binary;

/**
 * @author liuyi
 * @version 1.0
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @date 2022/8/12 10:43
 */
public class LC34 {
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
            //当数据范围较大时 就应该采用 lo + (hi - lo) / 2的方式
            mid = (lo + hi) / 2;
            if(nums[mid] == target){
                //左右扩散
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
}
