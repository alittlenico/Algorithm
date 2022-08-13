package com.lc.review.c6_dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 11:55
 */
public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        /**
         题目只需要判断填入的数字是否有效 我们可以按照规则来判断
         用hash表分别存储行 列 格子中出现的数 若重复则不合法
         */
        Map<Integer,Set<Integer>> row = new HashMap<Integer, Set<Integer>>();
        Map<Integer,Set<Integer>> column = new HashMap<Integer,Set<Integer>>();
        Map<Integer,Set<Integer>> box = new HashMap<Integer,Set<Integer>>();
        for(int i = 0;i < 9;++i){
            row.put(i,new HashSet<>());
            column.put(i,new HashSet<>());
            box.put(i,new HashSet<>());
        }
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board[i].length;++j){
                char c = board[i][j];
                if(c == '.') continue;
                int x = c - '0';
                //格子与坐标的关系
                int idx = (i / 3) * 3 + (j / 3);
                if(row.get(i).contains(x) || column.get(j).contains(x) || box.get(idx).contains(x)) return false;
                row.get(i).add(x);
                column.get(j).add(x);
                box.get(idx).add(x);
            }
        }
        return true;
    }
}
