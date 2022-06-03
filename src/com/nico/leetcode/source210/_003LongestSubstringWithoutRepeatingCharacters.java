package com.nico.leetcode.source210;

import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int result = 0;//最长字符长度
        int len = s.length();
        int left = 0;int right = -1;
        for(left=0;left<len;){//枚举每个字符作为起始字符
            while (right+1<len){
                if(set.contains(s.charAt(right+1))){//当下一个字符重复时
                    break;
                }else{
                    set.add(s.charAt(right+1));
                    right++;
                }
            }
            result = result < set.size() ? set.size() : result;//更新最长字符长度
            set.remove(s.charAt(left));//移除当前起始字符
            left++;
        }
       return result;
    }

    public static void main(String[] args) {
        _003LongestSubstringWithoutRepeatingCharacters sol = new _003LongestSubstringWithoutRepeatingCharacters();
//        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sol.lengthOfLongestSubstring(" "));
    }
}
