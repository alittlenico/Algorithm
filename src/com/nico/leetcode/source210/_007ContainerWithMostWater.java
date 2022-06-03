package com.nico.leetcode.source210;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 * Example 3:
 *
 * Input: height = [4,3,2,1,4]
 * Output: 16
 *
 * Example 4:
 *
 * Input: height = [1,2,1]
 * Output: 2

 */
public class _007ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int area = 0;
        while(l < r){
            area = Math.max(area,(r-l)*(Math.min(height[l],height[r])));
            /**
             * 底边固定时 由较小的高决定面积 通过调节较小边 才有可能获得较大的高
             */
            if(height[l]<=height[r]) l++;
            else r--;
        }
        return  area;
    }

    public static void main(String[] args) {
        _007ContainerWithMostWater containerWithMostWater = new _007ContainerWithMostWater();
//        System.out.println(containerWithMostWater.maxArea(new int[]{1, 1}));
        System.out.println(containerWithMostWater.maxArea(new int[]{4,3,2,1,4}));
//        System.out.println(containerWithMostWater.maxArea(new int[]{1,2,1}));
    }
}
