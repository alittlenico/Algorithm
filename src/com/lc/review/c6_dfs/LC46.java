package com.lc.review.c6_dfs;
import java.util.*;
/**
 * @author liuyi
 * @version 1.0
 * @description: 全排列
 * @date 2022/8/15 10:03
 */
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(len == 0) return result;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(result,path,len,0,nums,used);
        return result;
    }

    public void dfs(List<List<Integer>> result,Deque<Integer> path,int len,int depth,int[] nums,boolean[] used){
        if(depth == len){
            result.add(new ArrayList<>(path));
        }
        for(int i = 0;i < len;i++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(result,path,len,depth+1,nums,used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
