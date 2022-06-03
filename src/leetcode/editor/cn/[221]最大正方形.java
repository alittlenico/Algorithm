package leetcode.editor.cn;//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1']
//,['1','0','0','1','0']]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [['0','1'],['1','0']]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [['0']]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 👍 1137 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        //dp[i][j]:以坐标(i,j)作为右下角的正方形最大的边长
        int[][] dp = new int[n][m];
        for(int i = 0;i < n; ++i) {
            for(int j = 0;j < m; ++j) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = minOfThree(dp[i][j-1], dp[i-1][j-1],dp[i-1][j]) + 1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res * res;
    }

    public int minOfThree(int a,int b,int c) {
        if(a < b) {
            if(a < c) {
                return a;
            }else {
                return c;
            }
        }else {
            if(b < c) {
                return  b;
            }else {
                return c;
            }
        }
    }

    public static void main(String[] args) {
//        Solution sol = new Solution();
//        sol.maximalSquare(new char[][]{{'0','1','1','0','1'},{'1','1','0','1','0'},
//                {'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},
//                {'0','0','0','0','0'} });


    }
}
//leetcode submit region end(Prohibit modification and deletion)
