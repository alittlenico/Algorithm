package com.nico.leetcode.source210;


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *  
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 */
public class _008LongestCommonPrefix {
    /**
     * 暴力法
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for(String str : strs){
            if(str.length()==0||prefix.length()==0) return "";
            //prefix不是当前字符串的前缀 从后缩短prefix 直到prefix为空字符串 str.indexOf("")为0
            while(str.indexOf(prefix)!=0) prefix = prefix.substring(0,prefix.length()-1);
        }
        return prefix;
    }

    public static void main(String[] args) {
        _008LongestCommonPrefix sol = new _008LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower", "xyz", "flow"}));
        System.out.println(sol.longestCommonPrefix(new String[]{"flower", "", "flow"}));
    }
}
