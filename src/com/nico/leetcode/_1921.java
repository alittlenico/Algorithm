package com.nico.leetcode;

import java.util.Arrays;

public class _1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int len = dist.length;
        double[] arr = new double[len];
        for(int i = 0;i < len;++i)
            arr[i] = (double)dist[i] / speed[i];
        Arrays.sort(arr);
        int lo = 0;int hi = len-1;
        int mid;
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(arr[mid] > mid){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return lo + 1;
    }

    public static void main(String[] args) {
        _1921 sol = new _1921();
        sol.eliminateMaximum(new int[]{5,4,3,3,3},new int[]{1,1,5,3,1});
    }
}
