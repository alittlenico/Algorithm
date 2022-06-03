package com.nico.sort;

import java.util.Random;

/**
 * 基于快排的快速选择算法
 * 找出第k大的数
 * 根据 算法导论 该算法平均复杂度o(n)
 */
public class QuickSelect {

    Random random = new Random();

    /**
     * 快排的特点是每次可以确定一个数的下标
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a,l,r);
        if(q == index) return a[q];
        return q < index ? quickSelect(a,q+1,r,index) : quickSelect(a,l,q-1,index);
    }

    //在[l,r]随机选取一个下标和l下标交换 该数作为快排基准
    public int randomPartition(int[] a, int l, int r) {
        int idx = random.nextInt(r - l + 1) + l;
        swap(a,l,idx);
        return partition(a,l,r);
    }
    //快排核心算法 以a[l]为基准 小于的数移动到左边 大于的数移动到右边
    public int partition(int[] a, int l, int r) {
        int pivot = a[l];
        while(l < r){
            while(l < r && a[r] >= pivot) --r;
            a[l] = a[r];
            while(l < r && a[l] <= pivot) ++l;
            a[r] = a[l];
        }
        a[l] = pivot;
        return l;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSelect sol = new QuickSelect();
        System.out.println(sol.findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(sol.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
