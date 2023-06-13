package leetcode.editor.cn;//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 212 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1020 {
    int cnt;
//    int[][] used
//    List<int[]> g = new ArrayList<>();
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0;i < n;++i) {
            for (int j = 0;j < m;++j) {
                if (grid[i][j] == 1) {
                    ++cnt;
                }
            }
        }
        for (int i = 0;i < n;++i) {
            dfs(grid, i,0,n,m);
            dfs(grid, i, m - 1,n,m);
        }
        for (int j = 0;j < m;++j) {
            dfs(grid, 0, j,n,m);
            dfs(grid, n - 1, j,n,m);
        }
        return cnt;
    }

    private void dfs(int[][] grid, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) return;
        grid[x][y] = 0;
        cnt--;
        dfs(grid, x - 1, y, n, m);
        dfs(grid, x + 1, y, n, m);
        dfs(grid, x, y - 1, n, m);
        dfs(grid, x, y + 1, n, m);
    }

    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int[][] grids = {{0,0,0,0},
//                {1,0,1,0},
//                {0,1,1,0},
//                {0,0,0,0}};
//        sol.numEnclaves(grids);

        System.out.println(1 == '1');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
