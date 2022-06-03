package com.nico.leetcode.source210;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot
 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become
 * [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _020SearthInRotateSortedArray {
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

    public static void main(String[] args) {
        _020SearthInRotateSortedArray sol = new _020SearthInRotateSortedArray();
        System.out.println(sol.search(new int[]{3,1},1));
    }
}
