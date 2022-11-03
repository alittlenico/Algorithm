package com.nico.test;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/9/26 22:36
 */
public class JZ51 {

    public int count = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] res = mergeSort(nums,0,n-1);
        for(int i : res) System.out.print(i + " ");
        return count;
    }

    public int[] mergeSort(int[] nums,int low,int high) {
        if(high - low < 1) return new int[]{nums[low]};
        int mid = low + (high - low) / 2;
        int[] left = mergeSort(nums,low,mid);
        int[] right = mergeSort(nums,mid+1,high);
        int[] res = merge(left,right);
        return res;
    }

    public int[] merge(int[] left,int[] right) {
        int l = left.length;
        int r = right.length;
        int i = 0;int j = 0;
        int[] res = new int[l+r];
        int idx = 0;
        for(;i < l && j < r;) {
            if(left[i] > right[j]) {
                res[idx++] = right[j++];
                count += (l - i);
            }else {
                res[idx++] = left[i++];
            }
        }
        if(i != l) {
            for(;i < l;++i) {
                res[idx++] = left[i];
            }
        }
        if(j != r) {
            for(;j < r;++j) {
                res[idx++] = right[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JZ51 sol = new JZ51();
        sol.reversePairs(new int[]{1,3,2,3,1});
    }
}
