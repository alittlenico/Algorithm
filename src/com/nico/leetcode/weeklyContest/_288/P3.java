package com.nico.leetcode.weeklyContest._288;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/04/10/15:19
 * @Description:
 */
public class P3 {
    int mod = (int)(10e9 + 7);
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (x,y)-> x-y);
        for(int x : nums) {
            queue.add(x);
        }
        while(k > 0) {
            queue.add(queue.poll() + 1);
            --k;
        }
        long res = 1;
        while(queue.peek() != null) {
            res = (res * queue.poll()) % mod;
        }
        return (int)res;
    }

    @Test
    public void test() {
        int mod = (int)(1e9+7);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(mod);
    }
}
