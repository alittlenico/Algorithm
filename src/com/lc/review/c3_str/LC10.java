package com.lc.review.c3_str;

/**
 * @author liuyi
 * @version 1.0
 * @description: 10. 正则表达式匹配
 * @date 2022/6/24 14:45
 */
public class LC10 {
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
        for (int j = 1; j <= pCharLen; ++j) {
            //题目保证*前面一定有字符，因此不会下标越界
            if (pChar[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        //p为空 s不为空，一定不匹配，默认false不用初始化

        for (int i = 1; i <= sCharLen; ++i) {
            for (int j = 1; j <= pCharLen; ++j) {
                //如果s[i]与p[j]匹配
                if (sChar[i - 1] == pChar[j - 1] || pChar[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar[j - 1] == '*') {
                    //如果s[i]和p[j-1]匹配
                    if (sChar[i - 1] == pChar[j - 2] || pChar[j - 2] == '.') {
                        //匹配0次和多次(合并了1次和多次的情况 因为如果合并一次 上一次可以合并0次)
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        //不匹配
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sCharLen][pCharLen];
    }
}
