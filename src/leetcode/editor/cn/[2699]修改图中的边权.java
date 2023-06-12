package leetcode.editor.cn;//给你一个 n 个节点的 无向带权连通 图，节点编号为 0 到 n - 1 ，再给你一个整数数组 edges ，其中 edges[i] = [ai, bi,
//wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。 
//
// 部分边的边权为 -1（wi = -1），其他边的边权都为 正 数（wi > 0）。 
//
// 你需要将所有边权为 -1 的边都修改为范围 [1, 2 * 10⁹] 中的 正整数 ，使得从节点 source 到节点 destination 的 最短距
//离 为整数 target 。如果有 多种 修改方案可以使 source 和 destination 之间的最短距离等于 target ，你可以返回任意一种方案。
// 
//
// 如果存在使 source 到 destination 最短距离为 target 的方案，请你按任意顺序返回包含所有边的数组（包括未修改边权的边）。如果不存
//在这样的方案，请你返回一个 空数组 。 
//
// 注意：你不能修改一开始边权为正数的边。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, edges = [[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]], source = 0, 
//destination = 1, target = 5
//输出：[[4,1,1],[2,0,1],[0,3,3],[4,3,1]]
//解释：上图展示了一个满足题意的修改方案，从 0 到 1 的最短距离为 5 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 3, edges = [[0,1,-1],[0,2,5]], source = 0, destination = 2, target = 6
//输出：[]
//解释：上图是一开始的图。没有办法通过修改边权为 -1 的边，使得 0 到 2 的最短距离等于 6 ，所以返回一个空数组。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：n = 4, edges = [[1,0,4],[1,2,3],[2,3,5],[0,3,-1]], source = 0, destination 
//= 2, target = 6
//输出：[[1,0,4],[1,2,3],[2,3,5],[0,3,1]]
//解释：上图展示了一个满足题意的修改方案，从 0 到 2 的最短距离为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 1 <= edges.length <= n * (n - 1) / 2 
// edges[i].length == 3 
// 0 <= ai, bi < n 
// wi = -1 或者 1 <= wi <= 107 
// ai != bi 
// 0 <= source, destination < n 
// source != destination 
// 1 <= target <= 10⁹ 
// 输入的图是连通图，且没有自环和重边。 
// 
//
// Related Topics 图 最短路 堆（优先队列） 👍 61 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2669 {

    /**
     * 二分+朴素dijstra算法
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @param target
     * @return
     */
//    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
//        int k = 0;
//        for (int[] e : edges) {
//            if (e[2] == -1) ++k;
//        }
//        if (dijkstra(source, destination, construct(n, edges, 0, target)) > target) return new int[0][];
//        if (dijkstra(source, destination, construct(n,edges,(long) k * (target - 1), target))  < target) return new int[0][];
//
//        long left = 0, right = (long) k * (target - 1), ans = 0;
//        while (left <= right) {
//            long mid = (left + right) >> 1;
//            if (dijkstra(source, destination, construct(n, edges, mid,target )) >= target) {
//                ans = mid;
//                right = mid - 1;
//            }else {
//                left = mid + 1;
//            }
//        }
//
//        for (int[] e : edges) {
//            if (e[2] == -1) {
//                if (ans >= target - 1) {
//                    e[2] = target;
//                    ans -= (target - 1);
//                }else {
//                    e[2] = (int)(1 + ans);
//                    ans = 0;
//                }
//            }
//        }
//        return edges;
//    }
//
//    private final int INF = 0x3f3f3f3f;
//
//    /**
//     * 根据当前是第几种边序列方案构造邻接表
//     * @param n
//     * @param edges
//     * @param idx 从0开始
//     * @param target
//     * @return
//     */
//    public int[][] construct(int n, int[][] edges, long idx, int target) {
//        int[][] adjMatrix = new int[n][n];
//        for (int i = 0;i < n;++i) {
//            Arrays.fill(adjMatrix[i], -1);
//        }
//        for (int[] e : edges) {
//            int u = e[0], v = e[1], w = e[2];
//            if (w != -1) {
//                adjMatrix[u][v] = adjMatrix[v][u] = w;
//            }else {
//                if (idx >= target - 1) {
//                    adjMatrix[u][v] = adjMatrix[v][u] = target;
//                    idx -= (target - 1);
//                }else {
//                    adjMatrix[u][v] = adjMatrix[v][u] = (int)(1 + idx);
//                    idx = 0;
//                }
//            }
//        }
//        return adjMatrix;
//    }
//
//    public long dijkstra(int source, int destination, int[][] adjMatrix) {
//        int n = adjMatrix.length;
//        long[] dist = new long[n];
//        Arrays.fill(dist, INF);
//        boolean[] used = new boolean[n];
//        dist[source] = 0;
//
//        for (int round = 0;round < n - 1;++round) {
//            //从u-s中找出一个距离source最短的点
//            int u = -1;
//            for (int i = 0;i < n;++i) {
//                if (!used[i] && (u == -1 || dist[i] < dist[u])) {
//                    u = i;
//                }
//            }
//            //将该节点加入s
//            used[u] = true;
//            for (int v = 0; v < n;++v) {
//                if (!used[v] && adjMatrix[u][v] != -1) {
//                    dist[v] = Math.min(dist[v], dist[u] + adjMatrix[u][v]);
//                }
//            }
//        }
//        return dist[destination];
//    }

    private final int INF = Integer.MAX_VALUE;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < edges.length; ++i) {
            int x = edges[i][0], y = edges[i][1];
            g[x].add(new int[]{y, i});
            g[y].add(new int[]{x, i});
        }

        int[][] dist = new int[n][2];
        for (int i = 0;i < n;i++) {
            if (i != source) {
                dist[i][0] = dist[i][1] = INF;
            }
        }
        dijkstra(g, edges, destination, dist, 0, 0);
        int delta = target - dist[destination][0];
        if (delta < 0) return new int[0][];

        dijkstra(g, edges, destination, dist, delta, 1);
        if (dist[destination][1] < target) return new int[0][];

        for (int[] e : edges) {
            if (e[2] == -1) {
                e[2] = 1;
            }
        }
        return edges;
    }

    public void dijkstra(List<int[]>[] g, int[][] edges, int destination, int[][] dist, int delta, int k) {
        int n = g.length;
        boolean[] used = new boolean[n];
        for (;;) {
            int x = -1;
            for (int i = 0;i < n;++i) {
                if (!used[i] && (x == -1 || dist[i][k] < dist[x][k])) {
                    x = i;
                }
            }
            //?
            if (x == destination) return;
            used[x] = true;
            for (int[] e : g[x]) {
                int y = e[0] ,eid = e[1];
                int wt = edges[eid][2];
                if (wt == -1) {
                    wt = 1;
                }
                if (k == 1 && edges[eid][2] == -1) {
                    int w = delta + dist[y][0] - dist[x][1];
                    if (w > wt) {
                        edges[eid][2] = wt = w;
                    }
                }
                dist[y][k] = Math.min(dist[y][k], dist[x][k] + wt);
            }
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] edges = {{1,0,4},{1,2,3},{2,3,5},{0,3,-1}};
//        solution.modifiedGraphEdges(4, edges, 0, 2, 6);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
