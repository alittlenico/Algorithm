package com.nico.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _524_version1 {
    public static void main(String[] args) {
        _524_version1 sol = new _524_version1();
        String res = sol.findLongestWord("abpcplea",Arrays.asList("ale","apple","monkey","plea", "abpcplaaa","abpcllllll","abccclllpppeeaaaa"));
        System.out.println(res);
    }

    int m;
    public String findLongestWord(String s, List<String> dictionary) {
        //dp预处理s
        int sLen = s.length();
        /**
         dp[i][j]:s中位置i 字符下标j（a-z 对应下标 0-25）开始的第一个位置。
         */
        m = sLen + 1;
        int[][] dp = new int[m][26];
        for(int i = 0;i < sLen;++i) Arrays.fill(dp[i],m);
        for(int i = sLen - 1;i >= 0;--i){
            char curChar = s.charAt(i);
            for(int j = 0;j < 26;++j){
                if(curChar == (char)('a' + j)){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        Collections.sort(dictionary,(a,b) ->{
            if(a.length() != b.length()) return b.length() - a.length();
            else return a.compareTo(b);
        });
        int n = dictionary.size();
        for(int i = 0;i < n;++i){
            String word = dictionary.get(i);
            if(isSubSequence(word,dp)) return word;
        }
        return "";
    }

    boolean isSubSequence(String word,int[][] dp){
        int p = 0;
        for(int i = 0;i < word.length();++i){
            p = dp[p][word.charAt(i) - 'a'];
            if(p == m) return false;
            p = p + 1;
        }
        return true;
    }
}
