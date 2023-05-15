package leetcode.editor.cn;//给定 m x n 矩阵 matrix 。
//
// 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。） 
//
// 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[0,1],[1,1]]
//输出：1
//解释：不进行翻转，有 1 行所有值都相等。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1],[1,0]]
//输出：2
//解释：翻转第一列的值之后，这两行都由相等的值组成。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
//输出：2
//解释：翻转前两列的值之后，后两行由相等的值组成。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] == 0 或 1 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 110 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        char[] c = new char[n];
        for (int i = 0;i < m;++i) {
            Arrays.fill(c, '0');
            for (int j = 0;j < n;++j) {
                //翻转找本质相同的行 翻转开头为1的行(本质相同的行不是以1开头就是以0开头)
                c[j] = (char) ('0' + (matrix[i][0] ^ matrix[i][j]));
            }
            String key = new String(c);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;

        for(Map.Entry<String, Integer> e :  map.entrySet()) {
            res = Math.max(res, e.getValue());
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int[][] matrix = {{0, 1}, {1, 1}};
//        sol.maxEqualRowsAfterFlips(matrix);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
