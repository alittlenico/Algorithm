package leetcode.editor.cn;//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以
//决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。 
//
// 注意，删除一个元素后，子数组 不能为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。 
//
// 示例 2： 
//
// 
//输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
// 
//
// 示例 3： 
//
// 
//输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 219 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1186 {


    // todo-ly 2023/6/27 股票问题系列  
    /**
     * 考虑右边界能不能删除，子数组的最大值
     */
//    private int[] arr;
//    private int[][] memo;
//    public int maximumSum(int[] arr) {
//        this.arr = arr;
//        int res = Integer.MIN_VALUE,n = arr.length;
//        memo = new int[n][2];
//        for (int i = 0;i < n;++i) {
//            Arrays.fill(memo[i], Integer.MIN_VALUE);
//        }
//        for (int i = 0;i < n;++i) {
//            res = Math.max(res,Math.max(dfs(i,0),dfs(i,1)));
//        }
//        return res;
//    }
//
//    /**
//     *
//     * @param i 右端点
//     * @param j 0 不能删除数字 1 必须删除数字
//     * @return
//     */
//    private int dfs(int i, int j) {
//        if (i < 0) return Integer.MIN_VALUE / 2;
//        if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
//        if (j == 0) {
//            memo[i][j] = Math.max(dfs(i - 1, 0), 0 ) + arr[i];
//        }else {
//            memo[i][j] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
//        }
//        return memo[i][j];
//    }

    /**
     * 递归改成迭代 即为动态规划
     * 考虑右边界arr[i]
     *  不能删除数
     *      不选arr[i]左边的数 f[i][0] = arr[i]
     *      选左边的数 f[i][0] = f[i-1][0] + arr[i]
     *  必须删除
     *      删除arr[i] f[i][1] = f[i-1][0]
     *      不删除arr[i] f[i][1] = arr[i] + f[i-1][1]
     */
//    public int maximumSum(int[] arr) {
//        int res = Integer.MIN_VALUE, n = arr.length;
//        int[][] f = new int[n + 1][2];
//        Arrays.fill(f[0], Integer.MIN_VALUE / 2);
//        for (int i = 0;i < n;++i) {
//            f[i + 1][0] = Math.max(f[i][0] + arr[i], arr[i]);
//            f[i + 1][1] = Math.max(f[i][0], f[i][1] + arr[i]);
//            res = Math.max(res, Math.max(f[i + 1][0], f[i + 1][1]));
//        }
//        return res;
//    }

    /**
     * 优化空间复杂度
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        int res = Integer.MIN_VALUE, n = arr.length,f0 = Integer.MIN_VALUE / 2, f1 = f0;
        for (int i = 0;i < n;++i) {
            f1 = Math.max(f0, f1 + arr[i]);
            f0 = Math.max(f0 + arr[i], arr[i]);
            res = Math.max(res, Math.max(f0, f1));
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.maximumSum(new int[] {2,1,-2,-5,-2});
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
