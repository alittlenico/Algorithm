package leetcode.editor.cn;//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 638 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution509 {
    // todo-ly 2023/5/8 矩阵快速幂

    public int fib(int n) {
        if (n < 2) return n;
        int[][] q = {{1, 1}, {1, 0}};
        int[][] q_n = pow(q, n - 1);
        return q_n[0][0];
    }

    public int[][] pow(int[][] q, int n) {
        int[][] one = {{1, 0}, {0, 1}};
        while (n > 0) {
            //矩阵快速幂原理 奇数再多乘一个a
            if ((n & 1) == 1) {
                one = multiply(one, q);
            }
            //有符号右移
            n >>= 1;
            q = multiply(q, q);
        }
        return one;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[2][2];
        for (int i = 0;i < 2;i++) {
            for (int j = 0;j < 2;++j) {
                res[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
