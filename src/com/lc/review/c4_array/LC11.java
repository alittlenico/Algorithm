package com.lc.review.c4_array;

/**
 * @author liuyi
 * @version 1.0
 * @description:11. 盛最多水的容器
 * @date 2022/6/24 15:02
 */
public class LC11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
