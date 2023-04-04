package leetcode.editor.cn;//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
//
// Related Topics 广度优先搜索 字符串 回溯 👍 831 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution301 {
    String s_;
    Set<String> set = new HashSet<>();
    /**最大可能得分 最大合法字串的长度*/
    int max,n, len;
    public List<String> removeInvalidParentheses(String s) {
        s_ = s;
        n = s_.length();
        int l = 0,r = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) l++;
            else if (')' == c) r++;
        }
        max = Math.min(l,r);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    /**
     *
     * @param idx s字符的下标
     * @param curStr 当前字符串
     * @param score 当前得分
     */
    public void dfs(int idx, String curStr, int score) {
        if (score < 0 || score > max) return;
        //base 枚举到最后一个字符
        if (idx == n) {
            if (score == 0 && curStr.length() >= len) {
                //当前合法字符的长度比set中最大合法字符长度大 清空set数据
                if (curStr.length() > len) {
                    set.clear();
                    len = curStr.length();
                }
                set.add(curStr);
            }
            return;
        }
        char c = s_.charAt(idx);
        if (c == '(') {
            dfs(idx + 1, curStr + c, score + 1);
            dfs(idx + 1, curStr, score);
        }else if (c == ')') {
            dfs(idx + 1, curStr + c, score - 1);
            dfs(idx + 1, curStr, score);
        }else {
            dfs(idx + 1 ,curStr + c, score);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
