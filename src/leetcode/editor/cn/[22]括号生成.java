package leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3235 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {

    /**
     * 动态规划写法:使用数学归纳法
     * 对于i < n的所有括号排列清楚, i = n 整个排列最左边的是 ‘（’ 与它对于的 ‘）’,它们组成一对括号,可认为它是相对于n-1
     * 多出来的一对括号。另外的n-1对括号,可在（ + i= p) i=q  p + q = n - 1
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>(n + 1);
        if (n == 0) return new ArrayList<>();
        res.add(List.of(""));
        res.add(List.of("()"));
        for (int i = 2;i <= n;++i) {
            List<String> temp = new ArrayList<>();
            //枚举i - 1对括号
            for (int j = 0;j < i;++j) {
                List<String> p = res.get(j);
                List<String> q = res.get(i - 1 - j);
                for (String x : p) {
                    for (String y : q) {
                        temp.add("(" + x + ")" + y);
                    }
                }
            }
            res.add(temp);
        }
        return res.get(n);
    }

    /**
     * 回溯写法
     */
//    List<String> res = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        dfs(n, 0, 0, "");
//        return res;
//    }
//
//    private void dfs(int n, int left, int right, String cur) {
//        if (left == n && right == n) {
//            res.add(cur);
//            return;
//        }
//        //当前可选‘（’ 或 ‘）’
//        if (left + 1 <= n && right <= n && left >= right)
//            dfs(n, left + 1, right, cur + '(');
//        if (left <= n && right + 1 <= n && left >= right)
//            dfs(n, left, right + 1, cur + ')');
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
