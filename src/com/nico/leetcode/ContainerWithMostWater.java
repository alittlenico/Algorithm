package com.nico.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int area = 0;
        while(l < r){
            area = Math.max(area,(r-l)*(Math.min(height[l],height[r])));
            if(height[l]<=height[r]) l++;
            else r--;
        }
        return  area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
//        System.out.println(containerWithMostWater.maxArea(new int[]{1, 1}));
        System.out.println(containerWithMostWater.maxArea(new int[]{4,3,2,1,4}));
//        System.out.println(containerWithMostWater.maxArea(new int[]{1,2,1}));
    }
}
