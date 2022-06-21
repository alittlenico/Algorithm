package com.lc.review.c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @description: 三数之和
 * @date 2022/6/21 10:44
 */
public class LC15 {

    /* o(n^2) */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        //排序 o(nlogn)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //剪枝 跳过相同的数
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // a + b + c = 0 b + c = -a
            // target为第一个数
            int target = -nums[i];
            //第二个数 和 第三个数的下标
            int j = i + 1;
            int k = nums.length - 1;
            //二分减枝
            while (j < k) {
                //比target大 减小k，使得b + c 变小
                if (nums[j] + nums[k] > target) k--;
                //比target小 增大j,使得 b + c 变大
                else if (nums[j] + nums[k] < target) j++;
                //找到一组值
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    //跳过想同的数
                    while (j < nums.length && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return result;
    }
}
