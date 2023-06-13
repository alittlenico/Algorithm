package leetcode.editor.cn;//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2455 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution322 {
    //asw做的
    public int coinChange(int[] coins, int amount) {
        //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
        //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
        //使用助记数组dp[i]表示将amount表示的采用coins[0...i]这一组硬多尚需要的硬多尚
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        //表示满足none
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
