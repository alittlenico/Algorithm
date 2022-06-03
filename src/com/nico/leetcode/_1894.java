package com.nico.leetcode;

import org.junit.Test;

public class _1894 {
    public static void main(String[] args) {
        _1894 sol = new _1894();
        int res = sol.chalkReplacer(new int[]{5,1,5},22);
        System.out.println(res);
    }
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int n = chalk.length;
        int sum = 0;
        for(;i < n;++i){
            sum += chalk[i];
            if(sum >= k) break;
        }
        if(i == n){
            if(sum == k) return 0;
            else{
                int r = 1;
                for(;r * sum <= k;++r){}
                k -= (r - 1) * sum;
                int idx = 0;
                while(chalk[idx] <= k){
                    k -= chalk[idx++];
                }
                return idx;
            }
        }else{
            return i;
        }
    }

    @Test
    public void test(){
        int i = 0;
        for(;i < 3;++i){
            if(i == 2) break;
        }
        System.out.println(i);
    }
}
