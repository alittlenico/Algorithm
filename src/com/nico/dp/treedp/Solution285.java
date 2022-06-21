package com.nico.dp.treedp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 树形dp问题，不能选相邻节点，求选取节点的最大值
 */
public class Solution285 {

    //f[i][0] 不选取当前节点的最大高兴值 f[i][1] 选
    static int[][] f;
    static int[] h;
    static List<List<Integer>> adjacencyList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //高兴度
        h = new int[n];
        f = new int[n][2];
        for(int i = 0;i < n;++i) {
            h[i] = scanner.nextInt();
        }
        //使用邻接表存储树 索引+1 为节点实际名称
        adjacencyList = new ArrayList<>();
        for(int i = 0;i < n;++i) {
            List<Integer> temp = new ArrayList<>();
            adjacencyList.add(temp);
        }
        // 当前节点是否有父节点 索引+1 为节点实际名称
        boolean[] hasFather = new boolean[n];
        for(int i = 0;i < n - 1;++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            adjacencyList.get(b-1).add(a - 1);
            hasFather[a-1] = true;
        }
        //求出父节点
        int root = 0;
        while(hasFather[root]) {
            ++root;
        }
        dfs(root);
        System.out.println(Math.max(f[root][0], f[root][1]));
    }

    static void dfs(int node) {
        f[node][1] = h[node];
        //遍历当前节点的所有邻接节点
        for(int j : adjacencyList.get(node)) {
            dfs(j);
            f[node][0] += Math.max(f[j][0], f[j][1]);
            f[node][1] += f[j][0];
        }
    }
}
