package com.lc.review.c8_dp;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 16:02
 */
public class LC96 {
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;g[1] = 1;
        for(int i = 2;i <= n; ++i) {
            for(int j = 1;j <= i; ++j) {
                g[i] = g[i] + g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }
}
