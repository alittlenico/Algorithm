package com.nico.CombinatorialMathmaticsStudy;

import java.util.*;

/**
 * 数独方 0 1 2 3 中间编号为5
 * 使用回溯依次求出每个数独方的解
 * 枚举组合
 */
public class SolveShuDu {
    static List<char[][]> shudu0;
    static List<char[][]> shudu1;
    static List<char[][]> shudu2;
    static List<char[][]> shudu3;
    static Map<String,List<char[][]>> mapShudus = new HashMap<>();
    public static void main(String[] args) {
        char[][] board0 = {
                {'.','9','5','3','.','.','.','1','.'},
                {'7','.','.','.','1','.','.','.','3'},
                {'.','.','.','.','.','7','.','.','5'},
                {'.','.','7','.','.','.','.','.','1'},
                {'.','2','.','.','.','.','.','8','.'},
                {'1','.','.','.','.','.','6','.','.'},
                {'4','.','.','9','.','.','.','.','.'},
                {'2','.','.','.','4','.','.','.','6'},
                {'.','5','.','.','.','1','8','4','.'}
        };
        char[][] board1 = {
                {'.','2','5','3','.','.','.','6','.'},
                {'9','.','.','.','2','.','.','.','8'},
                {'.','.','.','.','.','6','.','.','4'},
                {'.','.','6','.','.','.','.','.','9'},
                {'.','4','.','.','.','.','.','5','.'},
                {'7','.','.','.','.','.','1','.','.'},
                {'6','.','.','7','.','.','.','.','.'},
                {'8','.','.','.','1','.','.','.','5'},
                {'.','5','.','.','.','4','3','9','.'}
        };
        char[][] board2 = {
                {'.','2','4','1','.','.','.','8','.'},
                {'6','.','.','.','9','.','.','.','5'},
                {'.','.','.','.','.','4','.','.','7'},
                {'.','.','1','.','.','.','.','.','9'},
                {'.','5','.','.','.','.','.','4','.'},
                {'7','.','.','.','.','.','2','.','.'},
                {'1','.','.','7','.','.','.','.','.'},
                {'3','.','.','.','8','.','.','.','6'},
                {'.','6','.','.','.','2','7','9','.'}
        };
        char[][] board3 = {
                {'.','1','2','3','.','.','.','7','.'},
                {'3','.','.','.','8','.','.','.','2'},
                {'.','.','.','.','.','6','.','.','3'},
                {'.','.','4','.','.','.','.','.','9'},
                {'.','9','.','.','.','.','.','8','.'},
                {'2','.','.','.','.','.','6','.','.'},
                {'9','.','.','1','.','.','.','.','.'},
                {'1','.','.','.','4','.','.','.','5'},
                {'.','5','.','.','.','7','2','1','.'}
        };
        char[][] board4 = {
                {'.','.','.','.','.','.','6','.','.'},
                {'.','.','6','.','.','.','8','.','.'},
                {'8','4','.','.','1','.','.','5','.'},
                {'.','.','.','3','.','6','.','.','.'},
                {'.','.','8','.','.','.','7','.','.'},
                {'.','.','.','5','.','9','.','.','.'},
                {'.','8','.','.','6','.','.','1','2'},
                {'.','.','5','.','.','.','3','.','.'},
                {'.','.','7','.','.','.','.','.','.'}
        };
        char[][] board4_copy = {
                {'.','.','.','.','.','.','6','.','.'},
                {'.','.','6','.','.','.','8','.','.'},
                {'8','4','.','.','1','.','.','5','.'},
                {'.','.','.','3','.','6','.','.','.'},
                {'.','.','8','.','.','.','7','.','.'},
                {'.','.','.','5','.','9','.','.','.'},
                {'.','8','.','.','6','.','.','1','2'},
                {'.','.','5','.','.','.','3','.','.'},
                {'.','.','7','.','.','.','.','.','.'}
        };
        shudu0 = SolveShuDuAPI.solveSudoku(board0);
        shudu1 = SolveShuDuAPI.solveSudoku(board1);
        shudu2 = SolveShuDuAPI.solveSudoku(board2);
        shudu3 = SolveShuDuAPI.solveSudoku(board3);
        for(int i = 0;i < shudu0.size();++i){
            char[][] temp0 = shudu0.get(i);
            for(int x = 0;x < 3;++x){
                for(int y = 0;y < 3;++y){
                    board4[x][y] = temp0[x+6][y+6];
                }
            }
            for(int x = 0;x < 3;++x){
                for(int y = 6;y < 9;++y){
                    board4[x][y] = board4_copy[x][y];
                }
            }
            for(int x = 6;x < 9;++x){
                for(int y = 0;y < 3;++y){
                    board4[x][y] = board4_copy[x][y];
                }
            }
            for(int x = 6;x < 9;++x){
                for(int y = 6;y < 9;++y){
                    board4[x][y] = board4_copy[x][y];
                }
            }
            if(!SolveShuDuAPI.isValidSudoku(board4)) continue;
            for(int j = 0;j < shudu1.size();++j){
                char[][] temp1 = shudu1.get(j);
                for(int x = 0;x < 3;++x){
                    for(int y = 6;y < 9;++y){
                        board4[x][y] = temp1[x+6][y-6];
                    }
                }
                for(int x = 6;x < 9;++x){
                    for(int y = 0;y < 3;++y){
                        board4[x][y] = board4_copy[x][y];
                    }
                }
                for(int x = 6;x < 9;++x){
                    for(int y = 6;y < 9;++y){
                        board4[x][y] = board4_copy[x][y];
                    }
                }
                if(!SolveShuDuAPI.isValidSudoku(board4)) continue;
                for(int k = 0;k < shudu2.size();++k){
                    char[][] temp2 = shudu2.get(k);
                    for(int x = 6;x < 9;++x){
                        for(int y = 0;y < 3;++y){
                            board4[x][y] = temp2[x-6][y+6];
                        }
                    }
                    for(int x = 6;x < 9;++x){
                        for(int y = 6;y < 9;++y){
                            board4[x][y] = board4_copy[x][y];
                        }
                    }
                    if(!SolveShuDuAPI.isValidSudoku(board4)) continue;
                    for(int q = 0;q < shudu3.size();++q){
                        char[][] temp3 = shudu3.get(q);
                        for(int x = 6;x < 9;++x){
                            for(int y = 6;y < 9;++y){
                                board4[x][y] = temp3[x-6][y-6];
                            }
                        }
                        if(SolveShuDuAPI.isValidSudoku(board4)){
                            //求解数独时 也会把其他地方角块改变
                            List<char[][]> temp = SolveShuDuAPI.solveSudoku(board4);
//                            SolveShuDuAPI.print(board4);
                            if(temp.size() > 0){
                                String str = i + " " + j + " " + " " + k + " " + q;
                                mapShudus.put(str,temp);
                            }
                        }
                    }
                }
            }
        }
        for(Map.Entry<String, List<char[][]>> entry: mapShudus.entrySet())
        {
            String[] idxStrs = entry.getKey().split("\\s+");
            for(int i = 0;i < idxStrs.length;++i){
                System.out.print("由编号为"+i+"的数独的第"+idxStrs[i]+"解;");
            }
            System.out.println("组合的解:");
            List<char[][]> board4List = entry.getValue();
            for(int i = 0;i < board4List.size();++i){
                System.out.println("该组合第"+i+"个解:");
                System.out.println("编号为0数独:");
                SolveShuDuAPI.print(shudu0.get(Integer.parseInt(idxStrs[0])));
                System.out.println("编号为1数独:");
                SolveShuDuAPI.print(shudu1.get(Integer.parseInt(idxStrs[1])));
                System.out.println("编号为2数独:");
                SolveShuDuAPI.print(shudu2.get(Integer.parseInt(idxStrs[2])));
                System.out.println("编号为3数独:");
                SolveShuDuAPI.print(shudu3.get(Integer.parseInt(idxStrs[3])));
                System.out.println("编号为4数独:");
                SolveShuDuAPI.print(board4List.get(i));
            }
        }
    }
}