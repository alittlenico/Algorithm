package com.lc.review.c4_array;

/**
 * @author liuyi
 * @version 1.0
 * @description: 删除重复元素
 *
 * @date 2022/8/6 10:19
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 1) return nums.length;
        int i = 0; int j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                ++j;
            }else{
                nums[++i] = nums[j++];
            }
        }
        return i+1;
    }
}
