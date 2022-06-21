package com.nico.dp.treedp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 状态机
 */
public class Solution323 {

    static List<List<Integer>> adjacencyList;
    static int[][] f;

    static boolean[] hasFather;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int nodeNum = scanner.nextInt();
            //f[i][0] 当前节点不选 f[i][1] 当前节点选择的最小士兵数
            f = new int[nodeNum][2];
            // hasFather[i]当前节点是否有父节点
            hasFather = new boolean[nodeNum];
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < nodeNum; ++i) {
                adjacencyList.add(new ArrayList<>());
            }
            for (int i = 0; i < nodeNum; ++i) {
                String next = scanner.next();
                //System.out.println("next:"+next);
                String[] split = next.split(":");
                int childNodeNum = Integer.parseInt(split[1].substring(1, split[1].length() - 1));
                while (--childNodeNum >= 0) {
                    int childNode = scanner.nextInt();
                    //System.out.print(childNode+"    ");
                    adjacencyList.get(Integer.parseInt(split[0])).add(childNode);
                    hasFather[childNode] = true;
                }
            }
            //寻找父节点
            int root = 0;
            while (hasFather[root]) {
                ++root;
            }
            dfs(root);
            System.out.println(Math.min(f[root][0], f[root][1]));
        }
    }

    static void dfs(int u) {
        f[u][0] = 0;
        f[u][1] = 1;
        for(int node : adjacencyList.get(u)) {
            dfs(node);
            f[u][0] += f[node][1];
            f[u][1] += Math.min(f[node][0], f[node][1]);
        }
    }
}
