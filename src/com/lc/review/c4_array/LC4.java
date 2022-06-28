package com.lc.review.c4_array;

import java.util.ArrayList;

/**
 * @author liuyi
 * @version 1.0
 * @description: 4. 寻找两个正序数组的中位数
 * @date 2022/6/24 9:41
 */
public class LC4 {


    /**
     * 归并排序，存储两个数组元素，返回中位数。
     * 不满足要求
     * o(m + n) s(m + n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                list.add(nums1[i]);
                ++i;
            } else {
                list.add(nums2[j]);
                ++j;
            }
        }
        if (i == m)
            for (; j < n; ++j) list.add(nums2[j]);
        if (j == n)
            for (; i < m; ++i) list.add(nums1[i]);
        if ((m + n) % 2 == 1) return (double) list.get((m + n) / 2);
        else {
            int idx = (m + n) / 2;
            int a = list.get(idx);
            int b = list.get(idx - 1);
            return ((double) (a + b)) / 2;
        }
    }

    // TODO: 2022/6/24
    /**
     * 凡是涉及到log时间复杂度，考虑二分法。
     * 1.本问题可以转化为有序数组中第k小的数
     * 2.根据奇偶情况，k=(m + n) / 2 ((m+n) / 2 + 1 + (m + n) / 2)
     * 3.比较A[k/2 - 1] B[k/2 - 1],我们可以知道，比二者最小值小的数不超过k-2个
     * 4.根据比较关系，排除数据
     * 5.可以通过偏移的方式和减去k/2来处理。
     * 6.要注意边界情况，越界 数组为null等情况
     */
}
