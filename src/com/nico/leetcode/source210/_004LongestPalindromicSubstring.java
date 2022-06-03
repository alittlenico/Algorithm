package com.nico.leetcode.source210;

/**
 *
 */
public class _004LongestPalindromicSubstring {



    public static void main(String[] args) {
        _004LongestPalindromicSubstring sol = new _004LongestPalindromicSubstring();
        System.out.println(sol.longestPalindrome3("bb"));
    }



    /**
     * 方法1 - 3均采用动态规划策略 具体实现略有不同
     * 采用 方法3最佳
     * @param s
     * @return
     */

    public String longestPalindrome3(String s) {
        int n = s.length();
        //标识最大回文字串的长度
        int maxLen = 1;
        //记录最大回文串 左边界下标
        int begin = 0;
        if(n < 2) return s;
        //标识 字串是否为回文串
        boolean[][] dp = new boolean[n][n];
        char[] charArr = s.toCharArray();
        //长度为1的字串是回文串
        for(int i = 0;i < n;i++){
            dp[i][i] = true;
        }
        //字串长度从小到大 规划
        for(int len = 2;len < n;len++){
            for(int i = 0;i < n;i++){//i为左边界
                int j = len + i - 1;//len 和 i确定右边界
                if(j == n) break; //右边界刚越界
                //首尾字符不同 一定不是回文串
                if(charArr[i] != charArr[j]) dp[i][j] = false;
                else{//首尾字符相同
                    //字串长度不超过3
                    if((j - i + 1) <= 3) dp[i][j] = true;
                    else{// 状态转移
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                //更新 maxLen 和 begin
                if(dp[i][j]&&(j - i +1) > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }


    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {// l = j - i 代表字串长度-1
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                boolean isEquals = false;
                //判断首尾字母是否相同
                isEquals = s.charAt(i) == s.charAt(j);
                if (l == 0) { //长度为1
                    dp[i][j] = true;
                } else if (l == 1 || l == 2) { //长度为2 或 3
                    dp[i][j] = isEquals;
                } else {//状态转移
                    dp[i][j] = (isEquals && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 可读性太差了
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        // 特判
        if (len < 2){
            return s;
        }
        int maxLen = 1;
        int begin  = 0;
        // 1. 状态定义
        // dp[i][j] 表示s[i...j] 是否是回文串
        // 2. 初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 3. 状态转移
        // 注意：先填左下角
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for (int j = 1;j < len;j++){
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return s.substring(begin,begin + maxLen);
    }

}
