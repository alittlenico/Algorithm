package com.nico.algorithmDesignAndImplStudy;

import java.util.Scanner;

/**
 * n皇后问题求解
 */
public class NQueensProblem {
    //最大不超过20
    int[] q = new int[20];
    //方案数
    int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        NQueensProblem sol = new NQueensProblem();
        sol.queen(0,n);
    }

    /**
     * @param i 第几行
     * @param n 总行数
     */
    void queen(int i,int n){
        //已放置完所有行的皇后
        if(i > n - 1) {
            ++count;
            printQueen(n);
        }
        else{
            //在i行下 遍历所有列 找到能放置的位置
            for(int j = 0;j < n;++j){
                if(place(i,j)){
                    q[i] = j;
                    queen(i + 1,n);
                }
            }
        }
    }

    /**
     * 打印一个问题的解
     * @param n 总行数
     */
    void printQueen(int n){
        System.out.print("第"+count+"个放置方案:  ");
        for(int i = 0;i < n;++i){
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param i 行
     * @param j 列
     * @return
     */
    boolean place(int i,int j){
        //第一行 能放置到任何列
        if(i == 0) return true;
        else{
            int k = 0;
            while(k < i){
                //和之前已放置好的皇后同列 或者 同对角线
                if(q[k] == j || Math.abs(k - i) == Math.abs(q[k] - j)) return false;
                ++k;
            }
        }
        return true;
    }
}
