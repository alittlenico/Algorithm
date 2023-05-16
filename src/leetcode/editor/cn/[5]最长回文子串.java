package leetcode.editor.cn;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6488 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划
     * o(n^2)
     * s(n^2)
     * @param s
     * @return
     */
//    public String longestPalindrome(String s) {
//        int n = s.length();
//        if (n < 2) {
//            return s;
//        }
//        int begin = 0;
//        int maxLen = 1;
//        //dp[i][j] 字符串中下标为i到j之间是否是回文串 i <= j
//        boolean[][] dp = new boolean[n][n];
//        for (int i = 0; i < n;++i) {
//            dp[i][i] = true;
//        }
//        //按长度枚举
//        for (int len = 2;len <= n;++len) {
//            for (int i = 0;i < n;++i) {
//                int j = i + len - 1;
//                if (j >= n) break;
//                if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
//                else {
//                    //长度小于等于3
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    }else {
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                }
//                if (dp[i][j] && (j - i + 1) > maxLen) {
//                    begin = i;
//                    maxLen = j - i + 1;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }

    /**
     * 中心扩展法
     */
    int start = 0, end = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        for (int i = 0;i < n;++i) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i+1);
        }
        return s.substring(start, end + 1);
    }

    public void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        int len = right - left - 1;
        if (len > end - start + 1) {
            start = left + 1;
            end = right - 1;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindrome("cbbd");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
