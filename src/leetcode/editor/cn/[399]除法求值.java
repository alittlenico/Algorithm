package leetcode.editor.cn;//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 最短路 👍 920 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution399 {
    public static void main(String[] args) {
        Solution399 sol = new Solution399();
        ArrayList<List<String>> equations = new ArrayList<>();
        ArrayList<String> equation = new ArrayList<>();
        equation.add("a");
        equation.add("b");

        ArrayList<String> equation1 = new ArrayList<>();
        equation1.add("b");
        equation1.add("c");

        equations.add(equation);
        equations.add(equation1);

        double[] values = new double[]{2.0, 3.0};


        ArrayList<List<String>> queries = new ArrayList<>();
        ArrayList<String> query = new ArrayList<>();
        query.add("a");
        query.add("c");

        ArrayList<String> query1 = new ArrayList<>();
        query1.add("b");
        query1.add("a");

        ArrayList<String> query2 = new ArrayList<>();
        query2.add("a");
        query2.add("e");

        ArrayList<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("a");

        ArrayList<String> query4 = new ArrayList<>();
        query4.add("x");
        query4.add("x");

        queries.add(query);
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);

        sol.calcEquation(equations, values, queries);
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int nodeNum = 0;
        //将字符与数字进行映射
        for (int i = 0;i < equations.size();++i) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!map.containsKey(a)) {
                map.put(a, nodeNum++);
            }
            if (!map.containsKey(b)) {
                map.put(b, nodeNum++);
            }
        }
        double[][] graph = new double[nodeNum][nodeNum];
        //初值
        for (int i = 0;i < nodeNum;++i) {
            Arrays.fill(graph[i], -1);
        }
        for (int i = 0;i < equations.size(); ++i) {
            Integer v1 = map.get(equations.get(i).get(0));
            Integer v2 = map.get(equations.get(i).get(1));
            graph[v1][v2] = values[i];
            graph[v2][v1] = 1 / values[i];
        }
        //floyd算法
        for (int k = 0;k < nodeNum;++k) {
            for (int i = 0;i < nodeNum;++i) {
                for (int j = 0;j < nodeNum;++j) {
                    //求到的结果即为唯一结果
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }
        double[] res = new double[queries.size()];
        //求解查询
        for (int i = 0;i < queries.size();++i) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            double result = -1;
            if (map.containsKey(a) && map.containsKey(b)) {
                Integer v1 = map.get(a);
                Integer v2 = map.get(b);
                if (graph[v1][v2] > 0) {
                    result = graph[v1][v2];
                }
            }
            res[i] = result;
        }
        return res;
    }


    /**
     * 转化为求有向图两点的距离
     * 1.字母转索引
     * 2.value值看作边上的权值,权值为正
     * 3.保证结果不矛盾，不存在有多个结果要求最短路径的情况。
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<Integer>();
                    points.offer(ia);
                    //ratios存放到当前节点值  a -> b v1 b -> c v2   ratios[0] ratios[1]
                    // a -> c = (a/c) = a/(b/v2) = a/b * v2  ratios[2]=ratios[1] * v2
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            //ratios是负 未更新数据或者为求到值
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }
}

class Pair {
    int index;
    double value;

    Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
