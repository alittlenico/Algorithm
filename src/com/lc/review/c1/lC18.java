package com.lc.review.c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @description: 四数之和
 * @date 2022/6/21 10:58
 */
public class lC18 {

    /*version 1*/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            //排除相同的数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t1 = target - nums[i];
            //转换为a+b+c=t1的三数之和问题
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int t2 = t1 - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > t2) right--;
                    else if (nums[left] + nums[right] < t2) left++;
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while (left < nums.length && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return result;
    }

    /*version2*/
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(nums.length / 4);
        if (nums == null || nums.length < 4) return new ArrayList<>(0);
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //过滤掉在当前i条件下 必定无解的情况
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            //最小的四个数之和也比target大 整体无解
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            int t1 = target - nums[i];
            //转换为a+b+c=t1的三数之和问题
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                //继续减枝
                if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        if (nums[i] + nums[j] + nums[left] + nums[right] > target) right--;
                        else if (nums[i] + nums[j] + nums[left] + nums[right] < target) left++;
                    }
                }
            }
        }
        return result;
    }
}
