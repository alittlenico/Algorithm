package com.lc.review.c4_array.binary;

/**
 * @author liuyi
 * @version 1.0
 * @description: 搜索插入位置
 * @date 2022/8/12 10:48
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;int right = nums.length-1;
        int mid = (left + right)/2;
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return nums[mid] < target ? mid + 1 : mid;
    }
}
