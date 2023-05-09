package leetcode.editor.cn;//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9021 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3_1 {

    // todo-ly 2023/5/5 21:03  
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0;
        int res = Integer.MIN_VALUE;
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        while (right < len) {
            Character c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                ++right;
                res = Math.max(res, right - left);
            }else {
                while (!Objects.equals(s.charAt(left),c)) {
                    set.remove(s.charAt(left));
                    ++left;
                }
                set.remove(left);
                ++left;
                set.add(c);
                right++;
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0,res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                left++;
                window.put(c1, window.get(c1) - 1);
            }
            res = Math.max(res,right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc";
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        System.out.println(set.contains(s.charAt(0)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
