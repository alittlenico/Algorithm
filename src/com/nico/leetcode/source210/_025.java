package com.nico.leetcode.source210;

import java.util.*;
public class _025 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates,target,result,path,0);
        return result;
    }

    public void dfs(int[] candidates,int target,List<List<Integer>> result,Deque<Integer> path,int begin){
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        for(int i = begin;i < candidates.length;i++){
            if(target - candidates[i] < 0) return;
            path.addLast(candidates[i]);
            dfs(candidates,target - candidates[i],result,path,begin);
            path.removeLast();
        }
    }

    public void test(){
        for(int i = 0;i< 10;i++){
            if(i == 5)
                break;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        _025 sol = new _025();
        sol.test();
//        sol.combinationSum(new int[]{2,3,6,7},7);
    }
}
