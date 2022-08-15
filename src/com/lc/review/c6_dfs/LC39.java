package com.lc.review.c6_dfs;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2022/8/14 20:26
 */
public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //stack
        Deque<Integer> path = new ArrayDeque<>();
        //排序方便减枝
        Arrays.sort(candidates);
        dfs(candidates,target,result,path,0);
        return result;
    }

    /**
     * 去重原理：从每层的第二个节点 都不能搜索同一层已经使用过的candidate里的元素
     * @param candidates
     * @param target
     * @param result
     * @param path
     * @param begin
     */
    public void dfs(int[] candidates,int target,List<List<Integer>> result,Deque<Integer> path,int begin){
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        for(int i = begin;i < candidates.length;i++){
            if(target - candidates[i] < 0) return;
            path.addLast(candidates[i]);
            dfs(candidates,target - candidates[i],result,path,i);
            path.removeLast();
        }
    }
}
