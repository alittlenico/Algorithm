package leetcode.editor.cn;//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格，和一个整型 k 。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 965 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution188 {

        final static Integer INF = Integer.MIN_VALUE / 2;
    int[] prices;
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        this.prices = prices;
        //dp[][0] 未持有 dp[][1] 持有
        dp = new int[n][k + 1][2];
        for (int i = 0;i < n;++i) {
            for (int j = 0;j <= k;++j) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        return dfs(n-1,k,0);
    }

    /**
     * 第i天结束时 自多交易k次 持有/不持有股票获得最大利润
     * @param i
     * @param hold
     * @return
     */
    private int dfs(int i, int j, int hold) {
        if (j < 0) return INF;
        if (i < 0) {
            return hold == 1 ? INF : 0;
        }
        if (dp[i][j][hold] != INF) return dp[i][j][hold];
        //一次买入卖出 算一次交易
        if (hold == 1) {
            dp[i][j][hold] = Math.max(dfs(i-1, j, 1), dfs(i-1,j-1,0) - prices[i]);
            return dp[i][j][hold];
        }
        dp[i][j][hold] = Math.max(dfs(i-1,j,0),dfs(i-1,j,1) + prices[i]);
        return dp[i][j][hold];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
