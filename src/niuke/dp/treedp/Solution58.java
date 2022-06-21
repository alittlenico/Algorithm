package niuke.dp.treedp;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: 红与蓝染色问题
 * @date 2022/6/19 16:51
 */
public class Solution58 {

    private static Map<Integer, List<Integer>> adjacencyMap;
    private static int[] dp;
    private static char[] color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        color = new char[n + 1];
        adjacencyMap = new HashMap<>();
        for(int i = 1;i < n; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //使用邻接表记录关系
            if(adjacencyMap.get(a) == null) {
                adjacencyMap.put(a, new ArrayList<Integer>(){{
                        add(b);
                    }}
                );
            }else {
                adjacencyMap.get(a).add(b);
            }
            if(adjacencyMap.get(b) == null) {
                adjacencyMap.put(b, new ArrayList<Integer>(){{
                            add(a);
                        }}
                );
            }else {
                adjacencyMap.get(b).add(a);
            }
        }
        dfs1(-1, 1);
        //检查是否有未染色的节点
        for(int i = 1;i < dp.length; ++i) {
            if (dp[i] == 0) {
                System.out.println(-1);
                return;
            }
        }
        color[1] = 'R';
        dfs2(-1, 1);
        for (int i = 1;i < color.length; ++i) {
            System.out.print(color[i]);
        }
    }
    /*染色*/
    static void dfs2(Integer pre, Integer cur) {
        for(Integer next : adjacencyMap.get(cur)) {
            if(next == pre) {
                continue;
            }
            //根据dp来染色 父节点同色 和父节点不同色
            color[next] = dp[cur] == next ? color[cur] : (color[cur] == 'R' ? 'B' : 'R');
            dfs2(cur, next);
        }
    }

    /*记录染色情况*/
    static void dfs1(Integer pre, Integer cur) {
        for(Integer next : adjacencyMap.get(cur)) {
            //排除父节点
            if(next == pre) {
                continue;
            }
            dfs1(cur, next);
            //如果相邻节点未染色 则染成同色
            if(dp[cur] == 0 && dp[next] == 0) {
                dp[cur] = next;
                dp[next] = cur;
            }
        }
    }
}
