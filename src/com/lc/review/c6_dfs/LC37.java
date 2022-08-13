package com.lc.review.c6_dfs;

import java.util.ArrayList;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/14 18:43
 */
public class LC37 {
    /**
     用三个布尔型数组 存储某行 某列 某3 X 3格子是否出现某个数字
     数组下标从0开始 用0代表数字1 或者第一行 第一列 第一格
     true 代表放置了数字。
     例：row[1][2] = true; 表示第2行放置了数字3
     */
    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][] box = new boolean[9][9];
    /**
     记录空格的坐标 对每个空格进行数字枚举
     */
    ArrayList<int[]> spaces = new ArrayList<>();
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        for(int i = 0;i < 9;++i){
            for(int j = 0;j < 9;++j){
                char c = board[i][j];
                if(c == '.'){
                    //记录下空格坐标
                    spaces.add(new int[]{i,j});
                }else{
                    int x = board[i][j] - '0' - 1;
                    //更新 row column box
                    int idx = (i / 3) * 3 + (j / 3);
                    row[i][x] = column[j][x] = box[idx][x] = true;
                }
            }
        }
        dfs(board,0);
    }

    void dfs(char[][] board,int pos){
        if(pos == spaces.size()){
            valid = true;
            return;
        }
        int posX = spaces.get(pos)[0];int posY = spaces.get(pos)[1];
        int idx = (posX / 3) * 3 + (posY / 3);
        for(int i = 0;i < 9;++i){
            if(!valid && !row[posX][i] && !column[posY][i] && !box[idx][i]){
                board[posX][posY] = (char)(i + '0' + 1);
                row[posX][i] = column[posY][i] = box[idx][i] = true;
                dfs(board,pos + 1);
                row[posX][i] = column[posY][i] = box[idx][i] = false;
            }
        }
    }
}
