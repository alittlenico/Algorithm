package leetcode.editor.cn;//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1213 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution312 {
    public int maxCoins(int[] nums) {
        /**
         * 区间dp dp[i][j] 开区间(i,j)戳破气球获得最大硬币数
         * 按长度枚举
         * 扩展原数组 处理具有一般性
         */


        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 1;i < n + 1;++i) {
            newNums[i] = nums[i-1];
        }
        //长度小于3的为0
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3;len <= n + 2;++len) {
            for (int i = 0;i + len - 1 < n + 2;++i) {
                int j = i + len - 1;
                for (int k = i + 1;k < j;++k) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
