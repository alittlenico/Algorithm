package com.nico.leetcode.source210;

import java.util.*;

public class _26 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        for(int i = 0;i < len;i++)
            used[i] = false;
        dfs(nums,0,result,path,used);
        return result;
    }

    public void dfs(int[] nums,int depth,List<List<Integer>> result,Deque<Integer> path,boolean[] used){
        if(depth == nums.length){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,i+1,result,path,used);
                path.removeLast();
                used[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        _26 sol = new _26();
        sol.permute(new int[]{1,2,3});
    }
}
