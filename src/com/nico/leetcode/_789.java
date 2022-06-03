package com.nico.leetcode;

public class _789 {
    public static void main(String[] args) {
        _789 sol = new _789();
        sol.escapeGhosts(new int[][]{{1,0},{0,3}},new int[]{0,1});
    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int n = ghosts.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;++i){
            int[] temp = ghosts[i];
            int x = Math.abs(temp[0] - target[0]);
            int y = Math.abs(temp[1] - target[1]);
            min = Math.min(min,x + y);
        }
        int xIdx = Math.abs(0 - target[0]);
        int yIdx = Math.abs(0 - target[1]);
        return xIdx + yIdx < min ? true : false;
    }
}
