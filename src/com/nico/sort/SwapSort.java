package com.nico.sort;

import java.util.Arrays;

public class SwapSort {

    void quickSort(int[] nums,int low,int high){
        if(low < high){
            int pivot = Partition(nums,low,high);
//            if(pivot == nums.length - k) {}
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }
    }
    int Partition(int[] nums,int low,int high){
        int pivot = nums[low];
        while(low < high){
            while(low < high && nums[high] >= pivot) --high;
            nums[low] = nums[high];
            while(low < high && nums[low] <= pivot) ++low;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
//        SwapSort sol = new SwapSort();
//        int[] nums = {49,38,65,97,76,13,27};
//        sol.quickSort(nums,0,nums.length - 1);
//        Arrays.stream(nums).forEach(System.out::println);
    }
}
