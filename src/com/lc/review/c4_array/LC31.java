package com.lc.review.c4_array;

/**
 * @author liuyi
 * @version 1.0
 * @description: 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * @date 2022/8/6 10:30
 */
public class LC31 {

    /**
     * 找到左边一个较小的数与右边一个较大的数交换
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        for(int i = nums.length-1;i > 0;i--){
            //从右往左找到第一组升序的数 nums[i-1] < num[i] 说明[i,....nums.length-1]是非升序的
            //即nums[i] >= nums[nums.length-1] 即右边的数是最小的
            if(nums[i-1] < nums[i]){
                //同时我们要让这个「较小数」尽量靠右，而「较大数」尽可
                //能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
                for(int j = nums.length -1;j >= i;j--){
                    if(nums[i-1] < nums[j]){
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        //之前已经证明[i,....nums.length-1]是非升序的
                        //交换nums[i-1]和nums[j]后:因为非升序 j+1 >= j >= i-1,而右边的数一定小于等于i-1(不然就交换了)
                        //所以交换后依然是非升序，反转区间即可变为升序
                        for(int k = i;k < (nums.length + i)/2;k++){
                            int temp1 = nums[nums.length-1+i-k];
                            nums[nums.length-1+i-k] = nums[k];
                            nums[k] = temp1;
                        }
                        return;
                    }
                }
            }
        }
        //当前已经是最大排列 逆序即可
        for(int i = 0;i < nums.length/2;i++){
            int temp = nums[nums.length-1-i];
            nums[nums.length-1-i] = nums[i];
            nums[i] = temp;
        }
    }
}
