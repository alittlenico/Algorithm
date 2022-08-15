package com.lc.review.c6_dfs;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description:  组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/8/15 9:44
 */
public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = candidates.length;
//        boolean[] used = new boolean[len];
        Arrays.sort(candidates);
        dfs(candidates,len,target,result,path,0);
        return result;
    }

    public void dfs(int[] candidates,int len,int target,List<List<Integer>> result,Deque<Integer> path,int begin){
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        for(int i = begin;i < len;i++){
            if(target - candidates[i] < 0) return;
            //减枝，candidates[i-1]已经把所有情况攘括进去了
            if(i > begin && candidates[i] == candidates[i-1]) continue;
            path.addLast(candidates[i]);
            dfs(candidates,len,target - candidates[i],result,path,i+1);
            path.removeLast();
        }
    }
}
