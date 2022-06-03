package com.nico.sort;

import org.junit.Test;

/**
 * 插入排序
 */
public class InsertSort {

    /**
     * 直接插入排序
     * 哨兵
     *
     * nums[0] 不存储元素
     * @param nums
     * @param n
     */
    void insertSort(int[] nums,int n){
        int i,j;
        for(i = 2;i <= n;++i){
            if(nums[i] < nums[i-1]){
                nums[0] = nums[i];
                for(j = i - 1;nums[0] < nums[j];--j)
                    nums[j+1] = nums[j];
                nums[j+1] = nums[0];
            }
        }
    }

}
