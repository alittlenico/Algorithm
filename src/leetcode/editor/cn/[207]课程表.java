package leetcode.editor.cn;//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1260 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution207 {

    // todo-ly 2023/5/6 11:16  
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储图关系的邻接矩阵
        List<List<Integer>> adj = new ArrayList<>();
        //每个节点的入度
        int[] indegree = new int[numCourses];
        //初始化
        for (int i = 0;i < numCourses;++i) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0;i < prerequisites.length;++i) {
            int[] prerequisite = prerequisites[i];
            //[1] -> [0]
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0;i < indegree.length;++i) {
            //入度为0
            if (indegree[i] == 0) {
                queue.addLast(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.removeFirst();
            count++;
            List<Integer> adjTemp = adj.get(top);
            //访问邻接课程
            for (int i = 0;i < adjTemp.size();++i) {
                Integer a = adjTemp.get(i);
                indegree[a]--;
                if (indegree[a] == 0) {
                    queue.addLast(a);
                }
            }
        }
        return count == numCourses;
    }
    
    
    
    
    
    
    
    
    
    
    
//    //记录图
//    List<List<Integer>> edges;
//    //每个节点的入度
//    int[] indegree;
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        edges = new ArrayList<>();
//        indegree = new int[numCourses];
//        for(int i = 0;i < numCourses; ++i) {
//            edges.add(new ArrayList<>());
//        }
//        for(int[] info : prerequisites) {
//            //info[1] --> info[0]
//            edges.get(info[1]).add(info[0]);
//            indegree[info[0]]++;
//        }
//        //初始化栈
//        Deque<Integer> stack = new LinkedList<>();
//        for(int i = 0;i < numCourses; ++i) {
//            //入度为零的点放入栈中
//            if(indegree[i] == 0) {
//                stack.push(i);
//            }
//        }
//        int count = 0;
//        while(!stack.isEmpty()) {
//            //输出栈顶元素
//            Integer popN = stack.pop();
//            ++count;
//            //访问当前节点所有相邻节点
//            for(int v : edges.get(popN)) {
//                indegree[v]--;
//                if(indegree[v] == 0) {
//                    stack.push(v);
//                }
//            }
//        }
//        if(count < numCourses) {
//            return false;
//        }else {
//            return true;
//        }
//    }


}
//leetcode submit region end(Prohibit modification and deletion)
