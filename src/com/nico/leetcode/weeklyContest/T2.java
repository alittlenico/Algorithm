package com.nico.leetcode.weeklyContest;

public class T2 {

    public static void main(String[] args) {
        T2 sol = new T2();
        sol.minStoneSum(new int[]{5,4,9},2);
    }
    int[] a;
    public int minStoneSum(int[] piles, int k) {
        int len = piles.length;
        a = new int[len + 1];
        for(int i = 0;i < len;++i){
            a[i+1] = piles[i];
        }
        buildMaxHeap(a,len);
        for(int i = 1;i <= k;++i){
            a[1] = a[1] - a[1] / 2;
            adjust(a,1,len);
        }
        int res = 0;
        for(int i = 1;i <= len;++i){
            res += a[i];
        }
        return res;
    }

    void buildMaxHeap(int[] a,int len){
        for(int i = a.length/2;i > 0;--i){
            adjust(a,i,len);
        }
    }

    void adjust(int[] a,int k,int len){
        a[0] = a[k];
        for(int i = 2*k;i <= len;i = 2*i){
            if(i < len && a[i] < a[i+1]){
                ++i;
            }
            if(a[0] >= a[i]) break;
            else{
                a[k] = a[i];
                k = i;
            }
        }
        a[k] = a[0];
    }
}
