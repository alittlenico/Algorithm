package leetcode.editor.cn;//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 👍 3014 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution10 {
    public boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int sCharLen = sChar.length;
        int pCharLen = pChar.length;
        //dp[i][j] s中前i个字符与p中前j个字符匹配情况，从1算起
        boolean[][] dp = new boolean[sCharLen + 1][pCharLen + 1];
        //s为空 p为空
        dp[0][0] = true;
        //s为空 p不为空,有可能匹配成功,*能消去前一个字符，若使得p为空串能匹配
        for(int j = 1;j <= pCharLen;++j) {
            //题目保证*前面一定有字符，因此不会下标越界
            if(pChar[j-1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        //p为空 s不为空，一定不匹配，默认false不用初始化

        for(int i = 1;i <= sCharLen; ++i) {
            for(int j = 1;j <= pCharLen; ++j) {
                //如果s[i]与p[j]匹配
                if(sChar[i - 1] == pChar[j - 1] || pChar[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar[j - 1] == '*') {
                    //如果s[i]和p[j-1]匹配
                    if(sChar[i - 1] == pChar[j - 2] || pChar[j - 2] == '.') {
                        //匹配0次和多次(合并了1次和多次的情况 因为如果合并一次 上一次可以合并0次)
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }else {
                        //不匹配
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sCharLen][pCharLen];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
