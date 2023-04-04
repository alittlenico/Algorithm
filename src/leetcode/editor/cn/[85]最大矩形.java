package leetcode.editor.cn;//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1500 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        //使用84 单调栈
        if (matrix.length == 0) return 0;
        int res = 0;
        int[] h = new int[matrix[0].length];
        for (int i = 0;i < matrix.length;++i) {
            for (int j = 0;j < matrix[0].length;++j) {
                if (matrix[i][j] == '1') {
                    h[j] = h[j] + 1;
                }else {
                    h[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(h));
        }
        return res;
    }

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
