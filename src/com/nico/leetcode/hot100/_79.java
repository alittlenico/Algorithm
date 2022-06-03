package com.nico.leetcode.hot100;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/04/10/17:44
 * @Description:
 */
public class _79 {
    boolean[][] flag;
    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        flag = new boolean[r][c];
        for(int i = 0;i < r;++i) {
            Arrays.fill(flag[i],false);
        }
        for(int i = 0;i < r; ++i) {
            for(int j = 0;j < c; ++j) {
                dfs(board,i,j,r,c,word,0);
                if(ans){
                    return true;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] board,int x,int y,int r,int c,String word,int cur) {
        if(cur == word.length()) {
            ans = true;
            return;
        }
        //ans为false 当前位置没有访问 且匹配
        if(!ans && !flag[x][y] && board[x][y] == word.charAt(cur)) {
            flag[x][y] = true;
            if(x + 1 >= 0 && x + 1 < r) {
                dfs(board,x + 1,y,r,c,word,cur+1);
                flag[x + 1][y] = false;
            }
            if(x - 1 >= 0 && x - 1 < r) {
                dfs(board,x - 1,y,r,c,word,cur+1);
                flag[x - 1][y] = false;
            }
            if(y + 1 >= 0 && y + 1 < c) {
                dfs(board,x,y + 1,r,c,word,cur+1);
                flag[x][y + 1] = false;
            }
            if(y - 1 >= 0 && y - 1 < c) {
                dfs(board,x,y - 1,r,c,word,cur+1);
                flag[x][y - 1] = false;
            }
            if( !(x + 1 >= 0 && x + 1 < r) &&
                    !(x - 1 >= 0 && x - 1 < r) &&
                    !(y + 1 >= 0 && y + 1 < c) &&
                    !(y - 1 >= 0 && y - 1 < c)
            ) {
                if(cur + 1 == word.length()) {
                    ans = true;
                    return;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        _79 sol = new _79();
        sol.exist(new char[][]{{'a'}},"a");
    }
}
