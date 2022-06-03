package com.nico.algorithmDesignAndImplStudy.homework;

/**
 * 分支限界法解决01背包问题
 * 3 30
 * 物品重量 [16 15 15]
 * 物品价值 [45 25 25]
 */


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 单个节点类
 * 1. 节点层次 对应于第几个物品
 * 2. 解向量 [0 0 0]
 * 3. 当前节点的总重量
 * 4. 当前节点的总价值
 * 5. 当前节点的上界值
 *
 */
class SNode{
    int level;
    int[] solVector = {0,0,0};
    int sumWeight;
    int sumValue;
    float upBound;
}

public class Solution {
    static final int WEIGHT = 30;
    static final int[] weightArray = {0,16,15,15};//首元素不取元素
    static final int[] valueArray = {0,45,25,25};
    static final int N = 3;
    static int maxVal = Integer.MIN_VALUE;
    static int[] bestSolVector = {0,0,0};//代表各元素是否取 1：取 0：不取
    Deque<SNode> queue = new ArrayDeque<>();//用队列存储bfs搜索时，访问的各个节点
    /**
     * 节点上界函数值，关键 不同的上界函数能有不同的剪枝效果
     * 限界函数的作用主要就是 提前判定当前节点下是否能找到最优解 从而实现减枝 提高搜索效率
     */
    void bound(SNode node){
        int level = node.level + 1;
        int sumWeight = node.sumWeight;
        int sumValue = node.sumValue;
        while(level <= N && sumWeight + weightArray[level] <= WEIGHT){
            sumWeight += weightArray[level];
            sumValue += valueArray[level];
            ++level;
        }
        if(level <= N){//剩余元素没取完
            node.upBound = sumValue +
                    (WEIGHT - sumWeight) *
                            valueArray[level] / weightArray[level];
        }else node.upBound = sumValue;
    }

    /**
     * 更新值 和 把节点入队列
     * @param node
     */
    void EnQueue(SNode node){
        if(node.level == N){
            if(node.sumValue > maxVal){
                //更新最大价值
                maxVal = node.sumValue;
                //更新解向量
                for(int i = 0;i < N;++i)
                    bestSolVector[i] = node.solVector[i];
            }
        }else queue.addLast(node);
    }

    /**
     * 广度优先遍历所有节点
     * 左节点代表 这个物品要选择
     * 右节点代表 这个物品不选择
     * 上界函数我们只用于右节点减枝
     */
    void bfs(){
        SNode root = new SNode();SNode left;SNode right;//分别代表根 左 右节点
        bound(root);
        queue.addLast(root);
        while(!queue.isEmpty()){
            root = queue.removeFirst();
            if(root.sumWeight + weightArray[root.level+1] <= WEIGHT){//下一个物品是否满足重量约束条件
                left = new SNode();
                left.level = root.level + 1;
                left.sumWeight = root.sumWeight + weightArray[root.level+1];
                left.sumValue = root.sumValue + valueArray[root.level+1];
                for(int i = 0;i < N; ++i)
                    left.solVector[i] = root.solVector[i];
                left.solVector[left.level-1] = 1;
                bound(left);
                EnQueue(left);//左节点入队
            }
            right = new SNode();
            right.level = root.level+1;
            right.sumValue = root.sumValue;
            right.sumWeight = root.sumWeight;
            for(int i = 0;i < N;++i) right.solVector[i] = root.solVector[i];
            right.solVector[right.level-1] = 0;
            bound(right);
            if(right.upBound > maxVal) EnQueue(right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.bfs();
        System.out.println("解向量:");
        Arrays.stream(bestSolVector).forEach(i-> System.out.print(i+" "));
        System.out.println("最大价值:"+maxVal);
    }
}
