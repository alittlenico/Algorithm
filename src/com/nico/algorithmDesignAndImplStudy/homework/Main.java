package com.nico.algorithmDesignAndImplStudy.homework;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * 使用分支界限法解决01背包问题
 */

//子集树的结构
class Node {
    public Node parent;   //记录子集树的父节点
    public boolean lChild; // 记录是左儿子还是右儿子

    public Node(Node parent, boolean lChild) {
        super();
        this.parent = parent;
        this.lChild = lChild;
    }
}


//对背包按照单位重量价值排序的类
class UnitW implements Comparable<UnitW> {
    public int id;
    public double d; //

    public UnitW(int id, double d) {
        super();
        this.id = id;
        this.d = d;
    }

    @Override
    public int compareTo(UnitW o) {  //按照d降序排列
//		return -(d > o.d ? 1 :( d == o.d ? 0 : -1 ));
        return -(Double.compare(d, o.d));

    }
}

class HeapNode implements Comparable<HeapNode> {

    public Node liveNode;  //活结点
    public int upProfit;   //活结点的价值上界
    public int profit;    //结点所相应的价值
    public int weight;    //结点所相应的重量
    public int level;    //结点在子集树中的层数

    public HeapNode(Node liveNode, int upProfit, int profit, int weight, int level) {
        super();
        this.liveNode = liveNode;
        this.upProfit = upProfit;
        this.profit = profit;
        this.weight = weight;
        this.level = level;
    }

    @Override
    public int compareTo(HeapNode o) {   //按照上界价值降序排列
//		return -(upProfit > o.upProfit ? 1 : (upProfit == o.upProfit ? 0: -1));
        return -(Integer.compare(upProfit, o.upProfit));
    }
}

public class Main {
    static int C;
    static int n;
    static int[] w;
    static int[] v;
    static int curW;  //当前的重量
    static int curVal;  //当前的价值
    static int[] bestX;  //记录最优解
    static PriorityQueue<HeapNode>heap;

    //计算最优上界
    static int getBound(int i) {
        int cLeft = C - curW;
        int b = curVal;        //价值的上界
        while (i < n && w[i] <= cLeft) { //以物品单位重量价值递减的顺序装填剩余容量
            cLeft -= w[i];
            b += v[i];
            i++;
        }
        if (i < n) b += v[i] * 1.0 / w[i] * cLeft;
        return b;
    }

    //生成一个活结点插入到子集树和最大堆中
    static void addLiveNode(int up, int v, int w, int lev, Node par, boolean iCh) {
        Node b = new Node(par, iCh);
        HeapNode hN = new HeapNode(b, up, v, w, lev); //生成一个堆元素
        heap.add(hN);             //加入到堆中
    }

    //分支限界法求解
    static int maxKnapsack() {
        Node endNode = null;
        int upProfit = getBound(0);  //计算一开始的上界
        int i = 0, bestV = 0;
        while (i != n) {
            if (curW + w[i] <= C) {  //进入左子树
                if (curVal + v[i] > bestV)
                    bestV = curVal + v[i];
                addLiveNode(upProfit, curVal + v[i], curW + w[i], i + 1, endNode, true); //左子树插入到最大堆中
            }

            upProfit = getBound(i+1);   //注意不是 (i) 计算下层的上界

            if (upProfit >= bestV)  //右子树可能含有最优解
                addLiveNode(upProfit, curVal, curW, i + 1, endNode, false);

            HeapNode top = heap.poll(); //把堆顶元素删掉
            endNode = top.liveNode;     //记录父亲结点
            curW = top.weight;
            curVal = top.profit;
            upProfit = top.upProfit;
            i = top.level;
        }
        //构造最优解
        for (int j = n - 1; j >= 0; j--) {
            bestX[j] = endNode.lChild ? 1 : 0;
            endNode = endNode.parent;
        }
        return curVal;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int T = cin.nextInt();//节点个数
        n = T;
        while(T-- > 0) {
            int sumW = 0, sumV = 0;
//            n = cin.nextInt();
//            n = T;
            C = cin.nextInt();
            int[] oriW = new int[n];   //体积
            int[] oriV = new int[n];   //价值
            for (int i = 0; i < n; i++) {
                oriW[i] = cin.nextInt();
                sumW += oriW[i];
            }
            for (int i = 0; i < n; i++) {
                oriV[i] = cin.nextInt();
                sumV += oriV[i];
            }
            if (sumW <= C) {
                System.out.println(sumV);
                continue;
            }
            UnitW[] unitWS = new UnitW[n];
            for (int i = 0; i < n; i++)
                unitWS[i] = new UnitW(i,oriV[i] * 1.0 / oriW[i]);
            Arrays.sort(unitWS);
            w = new int[n];
            v = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = oriW[unitWS[i].id];
                v[i] = oriV[unitWS[i].id];
            }
            bestX = new int[n];
            curW = 0;
            curVal = 0;
            heap = new PriorityQueue<>();
            int maxValue = maxKnapsack();
            System.out.println(maxValue);

            int[] res = new int[n + 1]; //保存结果
            for (int i = 0; i < n; i++)
                res[unitWS[i].id] = bestX[i];  //获取最优解

            System.out.println("---被选中物品的序号(从1开始)----");
            for (int i = 0; i < n; i++)
                if (res[i] == 1)
                    System.out.print(i + 1 + " ");
            System.out.println();
        }
    }
}


