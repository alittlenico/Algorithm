package com.nico.leetcode.source210;

public class _019NextPermutation {
    public int[] nextPermutation(int[] nums) {
        int flag = 0;
        for(int i = nums.length-1;i > 0;i--){
            if(nums[i-1] < nums[i]){
                for(int j = nums.length -1;j >= i;j--){
                    if(nums[i-1] < nums[j]){
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        for(int k = i;k < (nums.length + i)/2;k++){
                            int temp1 = nums[nums.length-1+i-k];
                            nums[nums.length-1+i-k] = nums[k];
                            nums[k] = temp1;
                        }
                        return nums;
                    }
                }
            }
        }
        for(int i = 0;i < nums.length/2;i++){
            int temp = nums[nums.length-1-i];
            nums[nums.length-1-i] = nums[i];
            nums[i] = temp;
         }
        return nums;
    }

    public static void main(String[] args) {
        _019NextPermutation sol = new _019NextPermutation();
        int[] nums = sol.nextPermutation(new int[]{5,4,7,5,5,3,2});
        System.out.println(nums);
    }
}
