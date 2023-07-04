package leetcode.editor.cn;//给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：
//
// 
// 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] 
//== 0 。 
// 
//
// 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,6]
//输出：2
//解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
// 
//
// 示例 2： 
//
// 输入：nums = [1,4,3]
//输出：2
//解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 14 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 19 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2741 {


    /**
     * 动态规划时间复杂度怎么算?
     * 动态规划的时间复杂度 === 状态个数 ×\times× 单个状态的计算时间。
     */
//    int n;
//    int mod;
//    public int specialPerm(int[] nums) {
//        mod = (int)(1e9 + 7);
//        n = nums.length;
//        int sum = 0;
//        for(int i = 0;i < n;++i) {
              //// 位运算知识 移除某个数
//            sum += dfs(((1 << n) - 1) ^ (1 << i),i,nums);
//        }
//        return sum % mod;
//    }
//
//    //i 以二进制方式代表可选数集合，从低位到高位表示0，1，2..n-1,1代表未选
//    //j上一个选择的下标
//    private int dfs(int i,int j,int[] nums) {
//        if (i == 0) return 1;
//        int res = 0;
//        for(int k = 0;k < n;++k) {
//            if((i >> k & 1) == 1 && (nums[k] % nums[j] == 0 || nums[j] % nums[k] == 0)) {
//                res += dfs(i ^ (1 << k), k, nums);
//            }
//        }
//        return res % mod;
//    }

    /**
     * 重复的计算? 0 1 2 4 8 .. 2^n,考虑这种情况，选了 0 1 2 和 2 1 0,后续的dfs的结果是一样的
     * @param nums
     * @return
     */
    public int specialPerm(int[] nums) {
        int mod = (int)1e9 + 7;
        int n = nums.length;
        int m = 1 << n;
        //f[i][j] 对应上面的i j参数
        int[][] f = new int[m][n];
        Arrays.fill(f[0], 1);
        // 填充完了 整个二维数组 能否保证我们的结果是正确的？
        for (int i = 1;i < m;++i) {
            for (int j = 0;j < n;++j) {
                for(int k = 0;k < n;++k) {
                    if ((i >> k & 1) == 1 && (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0)) {
                        f[i][j] = (f[i][j] + f[i ^ (1 << k)][k]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0;i < n;++i) {
            res = (res + f[(m - 1) ^ (1 << i)][i]) % mod;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
