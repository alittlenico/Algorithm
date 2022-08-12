package com.lc.review.c1;

import java.util.Arrays;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/6/28 17:39
 */
public class LC16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        //随意弄一个大数 大于nums中三个数与target差
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n - 2; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    public int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        int len = nums.length;
        int best = 13000;//target和nums中三个数的可能最大差
        int flag = -1;//false代表 和比target小 true代表和比target大
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = len - 1;
            int temp = target - nums[i];
            while (j < k) {
                int x = temp - (nums[j] + nums[k]);
                if (x == 0) return target;
                else {
                    if (x > 0) {
                        j++;
                    } else {
                        k--;
                    }
                    //flag对象是和best绑定的 当更新了best才需要更新flag
                    if (Math.abs(x) < best) {
                        best = Math.abs(x);
                        flag = x > 0 ? -1 : 1;
                    }
                }
                //对于第二个 和 第三个数 跳过相同的数 j > i + 1 j要从i+2开始才能去跳过，如果不判断
                // 则j第一轮是与nums[i]比较
                while (j < len && (j > i + 1) && nums[j] == nums[j - 1]) j++;
                //要判断k不能是数组右边界 否则nums[k+1] 要报越界异常
                while (j < k && (k < len - 1) && nums[k] == nums[k + 1]) k--;
            }
        }
        return best * flag + target;
    }
}
