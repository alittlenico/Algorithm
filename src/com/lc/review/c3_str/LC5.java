package com.lc.review.c3_str;

/**
 * @author liuyi
 * @version 1.0
 * @description: 最长回文字串
 * @date 2022/6/24 10:25
 */
public class LC5 {

    /**
     * dp枚举上三角，下一列的值依赖于前一列的值
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // 1. 状态定义
        // dp[i][j] 表示s[i...j] 是否是回文串
        // 2. 初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        //复杂不便理解
        // 3. 状态转移
        // 注意：先填左下角
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 便于理解，用dp，长度从小到大枚举
     * 1.dp[i][j] = dp[i + 1][j - 2] & char[i] == char[j]
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        int maxLen = 1;
        int begin = 0;
        if (n < 2) return s;
        boolean[][] dp = new boolean[n][n];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = len + i - 1;
                if (j == n) break;
                if (charArr[i] != charArr[j]) dp[i][j] = false;
                else {
                    if ((j - i + 1) <= 3) dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // TODO: 2022/6/24
    /**
     * 中心扩展法 南昌某公司 面试时 面试官问过
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        //所有的结果都是从单个字符或两个字符往外扩展的
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 从字串[left, right]往两边扩展的最大长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
