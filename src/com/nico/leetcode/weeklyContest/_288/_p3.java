package com.nico.leetcode.weeklyContest._288;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/04/10/15:35
 * @Description:
 */
public class _p3 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums){
            pq.offer(num);
        }
        for (int i = 0; i < k; i++){
            int num = pq.poll();
            num += 1;
            pq.offer(num);
        }
        long ans = 1;
        long MOD = 1000000007;
        for (int num : pq){
            ans = (num * ans) % MOD;
        }
        return (int)ans;
    }
}
