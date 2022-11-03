package acwing.dp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * 状态机
 */
public class Solution323 {

    static List<List<Integer>> adjacencyList;
    static int[][] f;

    static boolean[] hasFather;

    public static void main(String[] args) throws IOException {
        String file = "D:\\documentFile\\code\\develop\\project\\algorithm\\src\\acwing\\dp\\data.txt";
        String s = Files.readString(Paths.get(file));
        String[] lines = s.split("\r\n");
        int idx = 0;int n = lines.length;
        while(n > 0 && idx < n) {
            int nodeNum = Integer.parseInt(lines[idx]);
            //f[i][0] 当前节点不选 f[i][1] 当前节点选择的最小士兵数
            f = new int[nodeNum][2];
            // hasFather[i]当前节点是否有父节点
            hasFather = new boolean[nodeNum];
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < nodeNum; ++i) {
                adjacencyList.add(new ArrayList<>());
            }
            for (idx = 1; idx < n; ++idx) {
                String next = lines[idx];
                String[] split = next.split(":");
                int childNodeNum = Integer.parseInt(split[1].substring(1, split[1].indexOf(")")));
                String[] nodeVal = null;
                if(childNodeNum > 0) {
                    nodeVal = split[1].substring(split[1].indexOf(")") + 2, split[1].length())
                            .split(" ");
                }
                for(int k = 0;k < childNodeNum;++k) {
                    int childNode = Integer.parseInt(nodeVal[k]);
                    adjacencyList.get(Integer.parseInt(split[0])).add(childNode);
                    hasFather[childNode] = true;
                }

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


    static void dfs(int u) {
        f[u][0] = 0;
        f[u][1] = 1;
        for(int node : adjacencyList.get(u)) {
            dfs(node);
            f[u][0] += f[node][1];
            f[u][1] += Math.min(f[node][0], f[node][1]);
        }
    }

    @Test
    public void test() throws IOException {
//        String file = "D:\\documentFile\\code\\develop\\project\\algorithm\\src\\acwing\\dp\\data.txt";
//        String s = Files.readString(Paths.get(file));
//        System.out.println(s);
//        String[] split = s.split("\r\n");
//        for (String s1 :  split) System.out.println(s1);
        String s = "(123)";
        System.out.println(s.substring(1, s.indexOf(")")));
    }
}
