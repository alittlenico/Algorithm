package com.nico.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _322 {
    public static void main(String[] args) {
        _322 sol = new _322();
        System.out.println(sol.coinChange(new int[]{1,2,5},11));
    }

    int INF = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 0;
        for(int i = 1;i <= amount;++i){
            dp[0][i] = INF;
        }
        for(int i = 1;i <= n;++i){
            for(int j = 0;j <= amount;++j){
                //不考虑第i个硬币
                int a = dp[i-1][j];
                //考虑第i个硬币 每个硬币可使用多次
                int b = INF;
                for(int k = 0;j - coins[i-1]*k >= 0;++k){
                    if(dp[i-1][j-coins[i-1]*k] == INF) continue;
                    b = Math.min(b,dp[i-1][j-coins[i-1]*k] + k);
                }
                dp[i][j] = Math.min(a,b);
            }
        }
        return dp[n][amount] == INF ? -1 : dp[n][amount];
    }
}
