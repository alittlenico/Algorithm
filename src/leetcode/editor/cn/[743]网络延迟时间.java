package leetcode.editor.cn;//有 n 个网络节点，标记为 1 到 n。
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 479 👎 0


import org.junit.Test;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    /**用较大值初始化*/
    final int MAX_VALUE = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        //用邻接矩阵表示点到点之间的距离
        int[][] arcs = new int[n+1][n+1];
        //初始化
        for(int i = 1;i <= n; ++i) {
            Arrays.fill(arcs[i],MAX_VALUE);
        }
        for(int i = 0;i < times.length; ++i) {
            int[] row = times[i];
            int u = row[0];int v = row[1];int w = row[2];
            //填充arcs
            arcs[u][v] = w;
        }
        int[] dist = dijkstra(arcs,n,k);
        int res = -1;
        for(int i = 1;i <= n;++i) {
            if(i == k) {
                continue;
            }
            if(dist[i] == MAX_VALUE) {
                return -1;
            }
            res = Math.max(res,dist[i]);
        }
        return res;
    }

    /**dijkstra求单源最短路径*/
    int[] dijkstra(int[][] arcs, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,MAX_VALUE);
        dist[k] = 0;
        //已求得最短路径的节点
        Set<Integer> S = new HashSet<>();
        S.add(k);
        //根据邻接矩阵去设置dist值
        int[] row = arcs[k];
        for(int i = 1;i < row.length;++i) {
            if(i != k) {
                dist[i] = Math.min(dist[i],row[i]);
            }
        }
        //进行n-1轮
        for(int i = 1;i < n; ++i) {
            //s-v节点中从dist中选出距离最小的节点
            int minNodeValue = MAX_VALUE;
            int node = -1;
            for(int j = 1;j <= n;++j) {
                if(!S.contains(j)) {
                    if(minNodeValue >= dist[j]) {
                        minNodeValue = dist[j];
                        node = j;
                    }
                }
            }
            S.add(node);
            //更新s-v其他节点的到k最小值
            int finalNode = node;
            for(int j = 1;j <= n;++j) {
                if(!S.contains(j)) {
                    dist[j] = Math.min(dist[j]
                            ,dist[finalNode] + arcs[finalNode][j]);
                }
            }
        }
        return dist;
    }


    @Test
    public void test(){
        Solution3 sol = new Solution3();
        int res1 = sol.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2);
        int res2 = sol.networkDelayTime(new int[][]{{1,2,1}},2,1);
        int res3 = sol.networkDelayTime(new int[][]{{1,2,1}},2,2);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
