package leetcode.editor.cn;//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1712 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution200 {
    int cnt = 0;
    char[][] used;
    //按每个格子只会遍历一次 复杂度为 o(n * m)
    public int numIslands(char[][] grid) {
        //对grid进行深拷贝 复制到used
        int n = grid.length, m = grid[0].length;
        used = new char[n][m];
        for (int i = 0;i < n;++i) {
            System.arraycopy(grid[i], 0,used[i], 0, grid[i].length);
        }
        for (int i = 0;i < n;++i) {
            for (int j = 0;j < m;++j) {
                if (used[i][j] == '1') {
                    ++cnt;
                    dfs(grid,used,i,j,n,m);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, char[][] used, int x, int y, int n, int m) {
        if (!(x >= 0 && x < n && y >= 0 && y < m)) return;
        if (used[x][y] == '0') return;
        used[x][y] = '0';
        //遍历四个方向
        dfs(grid,used,x - 1, y,n,m);
        dfs(grid,used,x + 1, y,n,m);
        dfs(grid,used,x, y - 1,n,m);
        dfs(grid,used,x, y + 1,n,m);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
