package com.lc.review.c1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyi
 * @version 1.0
 * @description: 两数之和
 * @date 2022/6/21 10:55
 */
public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <=1) return new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //使用map来存储出现过的数
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]),i};
            else map.put(nums[i],i);
        }
        return new int[2];
    }
}
