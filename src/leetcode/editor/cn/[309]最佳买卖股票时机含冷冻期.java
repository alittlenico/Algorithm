package leetcode.editor.cn;//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1214 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        //f[i][0] 第i天结束后 持有股票的最大收益
        //f[i][1] 第i天结束后 不持有股票 且第二天为冻结期的最大收益
        //f[i][2] 第i天结束后 不持有股票 且第二天为非冻结期的最大收益
        f[0][0] = -1 * prices[0];
        //为什么设为0？
        f[0][1] = 0;
        f[0][2] = 0;
        for(int i = 1; i < n;++i) {
            //1.前一天持有股票，今天无操作 2.今天非冻结期，买入了股票，前一天不持有股票
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] - prices[i]);
            //1.今天卖出了股票
            f[i][1] = f[i-1][0] + prices[i];
            //1.今天不持有股票 且未卖出
            f[i][2] = Math.max(f[i-1][1], f[i-1][2]);
        }
        return Math.max(f[n-1][1], f[n-1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
