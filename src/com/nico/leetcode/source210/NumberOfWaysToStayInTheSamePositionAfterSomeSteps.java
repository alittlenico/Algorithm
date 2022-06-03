package com.nico.leetcode.source210;

public class NumberOfWaysToStayInTheSamePositionAfterSomeSteps {
    public int numWays(int steps, int arrLen) {
        final int base = 1000000007;
        int n = Math.min(arrLen - 1,steps);
        int[][] dp = new int[steps+1][n + 1];
        dp[0][0] = 1;
        for(int j = 1;j < n;j++){
            dp[0][j] = 0;
        }
        for(int i = 1;i < dp.length;i++){
            for(int j = 0;j < dp[i].length;j++){
                dp[i][j] = dp[i - 1][j];
                if(j == 0){
                    dp[i][j] = (0 + dp[i - 1][j] + dp[i - 1][j + 1]) % base;
                    continue;
                }
                if(j == dp[i].length - 1){
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1] + 0) % base;
                    continue;
                }
                //两个两个相加 防止溢出
                dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % base;
                dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % base;
            }
        }
        //721705292 914930753 954602812 2147483647
        return dp[steps][0];
    }

    public int numWays2(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {//不是起始元素
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                if (j + 1 <= maxColumn) {//不是最后一个元素
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }


    public static void main(String[] args) {
        NumberOfWaysToStayInTheSamePositionAfterSomeSteps sol = new NumberOfWaysToStayInTheSamePositionAfterSomeSteps();
        System.out.println(sol.numWays(27,7));
    }
}
