package com.nico.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumCloseest {
    //官解
    public int threeSumClosest2(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
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

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int x = (nums[0]+nums[1]+nums[len-1])-target; //当前数组中找到数值序列与target的差
        for(int i = 0;i < len - 2;i++){
            if(i > 0&&nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                int temp = sum - target;//差值
                if(temp == 0) return target;
                else{
                    x = Math.abs(x) < Math.abs(temp) ? x : temp;
                    if(temp < 0){ //比目标小，右移b
                        int _j = j + 1;
                        while(_j < len&& nums[_j] == nums[j]) _j++; // pass掉相同的元素
                        j = _j;
                    }else{//比目标大，左移c
                        int _k = k - 1;
                        while(j < _k&&nums[k] == nums[_k]) _k--;
                        k = _k;
                    }
                }
            }
        }
        return target + x;
    }

    public static void main(String[] args) {
        ThreeSumCloseest sol = new ThreeSumCloseest();
        System.out.println(sol.threeSumClosest(new int[]{1,1,1,1},1));
    }
}
