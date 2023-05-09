package leetcode.editor.cn;//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1139 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution438 {

    // todo-ly 2023/5/6 10:48
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();int m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }
        int left = 0, right = 0;
        int[] arr = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']++;
        }
        while (right < n) {
            //匹配上p字符 窗口变大
            if (arr[s.charAt(right) - 'a'] > 0) {
                arr[s.charAt(right) - 'a']--;
                ++right;
                if (right - left == m) {
                    res.add(left);
                    arr[s.charAt(left) - 'a']++;
                    ++left;
                }
            }else {
                arr[s.charAt(left) - 'a']++;
                ++left;
            }
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int valid = 0, left = 0, right = 0;
        for (int i = 0;i < p.length();++i) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        while (right < s.length() && (right - left) <= p.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) {
                valid++;
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (window.get(d).equals(need.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
