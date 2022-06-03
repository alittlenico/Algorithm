package com.nico.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeadSort {

    int headSortFindKthLargest(int[] nums,int len,int k){
        buildMaxHead(nums,len);
        for(int i = len;i > 1;--i){
            swap(1,i,nums);
            if(k == (len - i + 1)) return nums[i];
            headAdjust(nums,1,i-1);
        }
        return nums[1];
    }

    void headSort(int[] nums,int len){
        buildMaxHead(nums,len);
        for(int i = len;i > 1;--i){
            swap(1,i,nums);
            headAdjust(nums,1,i-1);
        }
    }

    void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 建立大根堆
     * @param nums
     * @param len
     */
    void buildMaxHead(int[] nums,int len){
        for(int i = len/2;i > 0;--i){
            headAdjust(nums,i,len);
        }
    }

    /**
     * 堆调整
     * @param nums
     * @param k
     * @param len
     */
    void headAdjust(int[] nums,int k,int len){
        nums[0] = nums[k];
        for(int i = k*2;i <= len;i *= 2){
            if(i < len && nums[i] < nums[i+1])
                ++i;
            if(nums[0] >= nums[i]) break;
            else{
                nums[k] = nums[i];
                k = i;
            }
        }
        nums[k] = nums[0];
    }

    public static void main(String[] args) {
        HeadSort sol = new HeadSort();
        int[] nums = {0,6,5,4,3,2,1};//第一个元素为闲置元素
        int val = sol.headSortFindKthLargest(nums,6,3);
        System.out.println(val);
//        sol.headSort(nums,nums.length-1);
//        for(int i = 1;i <= nums.length - 1;++i){
//            System.out.print(nums[i]+" ");
//        }
    }
}
