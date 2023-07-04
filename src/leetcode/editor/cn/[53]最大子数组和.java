package leetcode.editor.cn;//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4837 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {

    /**
     * i 右端点
     * j 要不要选 0 不能删除 1 必须删除
     *  f[i][]
     *
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        int res = Integer.MIN_VALUE,n = nums.length;
//        int[] dp = new int[n];
//        //dp[i] 以下标i结尾的连续子数组最大和
//        dp[0] = nums[0];
//        res = Math.max(dp[0], res);
//        for (int i = 1;i < n;++i) {
//            dp[i] = dp[i-1] <= 0 ? nums[i] : dp[i-1] + nums[i];
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }


    /**
     * 空间复杂度优化
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE,n = nums.length;
        int dp = nums[0];
        res = Math.max(res, dp);
        for (int i = 1;i < n;++i) {
            dp = dp <= 0 ? nums[i] : dp + nums[i];
            res = Math.max(res, dp);
        }
        return res;
    }
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int pre = nums[0];
//        int max = pre;
//        for(int i = 1;i < n; ++i) {
//            pre = Math.max(pre + nums[i], nums[i]);
//            max = Math.max(pre, max);
//        }
//        return max;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
