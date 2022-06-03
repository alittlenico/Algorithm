package com.nico.CombinatorialMathmaticsStudy;

import java.util.*;

/**
 * 这是一个专门解决数独问题的类
 */
public class SolveShuDuAPI {

    public SolveShuDuAPI(){};

    /**
     用三个布尔型数组 存储某行 某列 某3 X 3格子是否出现某个数字
     数组下标从0开始 用0代表数字1 或者第一行 第一列 第一格
     true 代表放置了数字。
     例：row[1][2] = true; 表示第2行放置了数字3
     */
    static boolean[][] row;
    static boolean[][] column;
    static boolean[][] box;
    /**
     记录空格的坐标 对每个空格进行数字枚举
     */
    static ArrayList<int[]> spaces;

    /**
     *
     * @param board 9 X 9 数独
     * @return 返回该数独所有解
     */
    public static List<char[][]> solveSudoku(char[][] board) {

        row = new boolean[9][9];
        column = new boolean[9][9];
        box = new boolean[9][9];
        spaces = new ArrayList<>();
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
        //求解完数独 要把数独还原
        char[][] board_cp = new char[9][9];
        for(int i = 0;i < 9;++i){
            board_cp[i] = board[i].clone();
        }
        List<char[][]> sudus = new ArrayList<>();
        dfs(board,0,sudus);
        for(int i = 0;i < 9;++i){
            board[i] = board_cp[i].clone();
        }
        return sudus;
    }

    public static void dfs(char[][] board,int pos,List<char[][]> sudus){
        if(pos == spaces.size()){
            char[][] tar = new char[board.length][board[0].length];
            for(int i = 0;i < board.length;++i) {
                tar[i] = board[i].clone();
            }
            sudus.add(tar);
            return;
        }
        int posX = spaces.get(pos)[0];int posY = spaces.get(pos)[1];
        int idx = (posX / 3) * 3 + (posY / 3);
        for(int i = 0;i < 9;++i){
            if(!row[posX][i] && !column[posY][i] && !box[idx][i]){
                board[posX][posY] = (char)(i + '0' + 1);
                row[posX][i] = column[posY][i] = box[idx][i] = true;
                dfs(board,pos + 1,sudus);
                row[posX][i] = column[posY][i] = box[idx][i] = false;
            }
        }
    }

    /**
     *
     * @param board 一个填入部分数字的数独
     * @return 填入数字是否满足数独规则
     */
    public static boolean isValidSudoku(char[][] board) {
        /**
         * 用布尔型二维数组 分别存储行 列 3X3格子 中出现了那些数字。
         * 因为下标从0开始,所以我们以下标加1代表实际存放的数字。
         * true:代表存放了该数字
         * 例：row[1][1] = true; 第2行存放了数字2
         */
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board[i].length;++j){
                char c = board[i][j];
                if(c == '.') continue;
                int x = c - '0' - 1;
                //格子与坐标的关系
                int idx = (i / 3) * 3 + (j / 3);
                if(row[i][x] || column[j][x] || box[idx][x]) return false;
                row[i][x] = true;
                column[j][x] = true;
                box[idx][x] = true;
            }
        }
        return true;
    }

    public static void print(char[][] board){
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board[i].length;++j){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------分割线------------------------");
    }
}
