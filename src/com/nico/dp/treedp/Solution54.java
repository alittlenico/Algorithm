package com.nico.dp.treedp;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/6/15 14:56
 */
public class Solution54 {

    private static int[] dp;
    private static Map<Integer,List<Integer>> adjacencyTable;
    private static List<Integer> query;
    private static int[] res;
    private static char[] ops;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //索引和节点名称对应 从下标1开始
        dp = new int[n + 1];
        adjacencyTable = new HashMap<>();
        for(int i = 0;i < n - 1; ++i) {
            int curParent = scanner.nextInt();
            if(adjacencyTable.get(curParent) == null) {
                adjacencyTable.put(curParent, new ArrayList<>());
            }
            adjacencyTable.get(curParent).add(i + 2);
        }
        ops = scanner.next().toCharArray();
        dfs(1);
        int queryNum = scanner.nextInt();
        res = new int[queryNum];
        for(int i = 0;i < queryNum; ++i) {
            res[i] = dp[scanner.nextInt()];
        }
        for(int x : res) {
            System.out.println(x);
        }
    }

    static void dfs(int u ) {
        if (ops[u-1] == 'R') {
            dp[u] += 1;
        }
        if(adjacencyTable.get(u) != null) {
            for (int x : adjacencyTable.get(u)) {
                dfs(x);
                dp[u] += dp[x];
            }
        }
    }
}
