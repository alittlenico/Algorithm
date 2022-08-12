package com.lc.review.c4_array.binary;

/**
 * @author liuyi
 * @version 1.0
 * @description: 搜索旋转排序数组
 *
 * @date 2022/8/12 10:34
 */
public class LC33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;int right = n-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){//左边有序
                if(nums[left] <= target && target <= nums[mid]){//目标存在于左边
                    right = mid -1;
                }else{//目标存在于右边
                    left = mid + 1;
                }
            }else{//右边有序
                if(nums[mid] <= target && target <= nums[right]){//目标存在于右边
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
