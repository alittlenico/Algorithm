package com.nico.leetcode;

import java.util.Arrays;

public class _576 {

    public static void main(String[] args) {
        _576 sol = new _576();
        System.out.println(sol.findPaths(2,2,2,0,0));
    }

    int mod = 1000000007;
    int[][] pairs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};//偏移增量
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] cache = new int[maxMove+1][m][n];
        for(int i = 0;i <= maxMove;++i){
            for(int j = 0;j < m;++j){
                Arrays.fill(cache[i][j],-1);
            }
        }
        return dfs(m,n,startRow,startColumn,maxMove,cache);
    }

    int dfs(int m,int n,int r,int c,int k,int[][][] cache){
        if(r < 0 || r >= m || c < 0 || r >= n) return 1;
        if(k <= 0) return 0;
        if(cache[k][r][c] != -1) return cache[k][r][c];
        int temp = 0;
        for(int[] p : pairs){
            int nr = r + p[0];int nc = c + p[1];
            if(nr >= 0 && nr < m && nc >= 0 && nr < n){
                temp += dfs(m,n,nr,nc,k-1,cache);
                temp %= mod;
            }
        }
        cache[k][r][c] = temp;
        return cache[k][r][c];
    }
}
