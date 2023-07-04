package leetcode.editor.cn;//给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k 表示等待分发零食包的孩子数量，所有
//零食包都需要分发。在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。 
//
// 分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。 
//
// 返回所有分发的最小不公平程度。 
//
// 
//
// 示例 1： 
//
// 输入：cookies = [8,15,10,20,8], k = 2
//输出：31
//解释：一种最优方案是 [8,15,8] 和 [10,20] 。
//- 第 1 个孩子分到 [8,15,8] ，总计 8 + 15 + 8 = 31 块饼干。
//- 第 2 个孩子分到 [10,20] ，总计 10 + 20 = 30 块饼干。
//分发的不公平程度为 max(31,30) = 31 。
//可以证明不存在不公平程度小于 31 的分发方案。
// 
//
// 示例 2： 
//
// 输入：cookies = [6,1,3,2,2,4,1,2], k = 3
//输出：7
//解释：一种最优方案是 [6,1]、[3,2,2] 和 [4,1,2] 。
//- 第 1 个孩子分到 [6,1] ，总计 6 + 1 = 7 块饼干。 
//- 第 2 个孩子分到 [3,2,2] ，总计 3 + 2 + 2 = 7 块饼干。
//- 第 3 个孩子分到 [4,1,2] ，总计 4 + 1 + 2 = 7 块饼干。
//分发的不公平程度为 max(7,7,7) = 7 。
//可以证明不存在不公平程度小于 7 的分发方案。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cookies.length <= 8 
// 1 <= cookies[i] <= 10⁵ 
// 2 <= k <= cookies.length 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 64 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution2305 {

    // todo-ly 2023/6/26 可以优化为o(n)空间复杂度  
    final int INF = 0x3f3f3f3f;
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        // 以二进制位代表集合 1 在集合里 0 不在集合里
        //sum 对应集合的总和
        int[] sum = new int[1 << n];
        for (int i = 0;i < 1 << n;++i) {
            for(int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) sum[i] += cookies[j];
            }
        }
        //f[i][j] 消耗了i个子序列 组成了集合j,前i个孩子分发j个零食包的最小不公平度
        //考虑第i个孩子，分发s个零食包
        //sum[s] >= f[i-1][j ^ s] f[i][j] = sum[s]
        //sum[s] < f[i-1][j ^ s] f[i][j] = sum[s]
         int[][] f = new int[k][1 << n];
        //f[0] 消耗了一个子序列
        f[0] = sum.clone();
        for (int i = 1;i < k;++i) {
            for (int j = 0;j < 1 << n;++j) {
                f[i][j] = INF;
                //枚举子集的技巧:10110 代表 {1，2，4},10110 - 1 = 10101, 10110 & 10101 = 10100 {2,4}
                //因为每次减一 所以不会漏数
                for (int s = j;s > 0;s = (s - 1) & j) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[i - 1][j ^ s], sum[s]));
                }
            }
        }
        return f[k-1][(1 << n) - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
