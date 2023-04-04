package leetcode.editor.cn;//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2378 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        //单调栈
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        //存放左边最近比i小的下标
        int[] l_s = new int[n];
        Arrays.fill(l_s,-1);
        //存放右边最近比i小得下标
        int[] r_s = new int[n];
        Arrays.fill(r_s, n);
        for(int i = 0;i < n;++i) {
            while (!stack.isEmpty() && heights[stack.peekFirst()] > heights[i]) r_s[stack.removeFirst()] = i;
            stack.addFirst(i);
        }
        stack.clear();
        for (int i = n - 1;i >= 0;--i) {
            while (!stack.isEmpty() && heights[stack.peekFirst()] > heights[i]) l_s[stack.removeFirst()] = i;
            stack.addFirst(i);
        }
        int res = 0;
        for(int i = 0;i < n;++i) {
            int h = heights[i],a = l_s[i],b = r_s[i];
            res = Math.max(res, (b - a - 1)*h);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
