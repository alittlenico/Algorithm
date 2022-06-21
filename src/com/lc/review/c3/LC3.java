package com.lc.review.c3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuyi
 * @version 1.0
 * @description: 无重复字符的最长子串
 * @date 2022/6/21 11:49
 */
public class LC3 {

    /***
     * version 1
     * 用set存储不重复元素，i和j维护一个滑动窗口，不断更新最大值
     * 推荐
     * o(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int length = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                length = Math.max(length, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return length;
    }

    /***
     * version 2
     * 难懂且不如1简洁
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int result = 0;//最长字符长度
        int len = s.length();
        int left = 0;
        int right = -1;
        for (left = 0; left < len; ) {//枚举每个字符作为起始字符
            while (right + 1 < len) {
                if (set.contains(s.charAt(right + 1))) {//当下一个字符重复时

                    break;
                } else {
                    set.add(s.charAt(right + 1));
                    right++;
                }
            }
            result = result < set.size() ? set.size() : result;//更新最长字符长度
            set.remove(s.charAt(left));//移除当前起始字符
            left++;
        }
        return result;
    }
}
