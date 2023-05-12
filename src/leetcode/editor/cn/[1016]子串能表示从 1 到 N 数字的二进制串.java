package leetcode.editor.cn;//给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回
//false 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0110", n = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "0110", n = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 不是 '0' 就是 '1' 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 字符串 👍 103 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1016 {

    public boolean queryString(String s, int n) {
        for (int i = 1;i <= n;++i) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }


//    public boolean queryString(String s, int n) {
//        if (n == 1) {
//            return s.indexOf('1') != -1;
//        }
//        //int 32位 不使用有符号位有31位 可以移动30位 找到使得 n < 2^(k)
//        // 2^30 = 1,073,741,824 > 10^9
//        int k = 30;
//        while ((1 << k) > n) {
//            --k;
//        }
//        //s.length() <= 1000 -> k <=10
//        if (s.length() < (1 << (k -1)) + k -1 || s.length() < (n - (1 << k)) + k + 1) {
//            return false;
//        }
//        return help(s, k, 1 << (k - 1), (1 << k) - 1) && help(s, k + 1, 1 << k, n);
//    }
//
//    public boolean help(String s, int k, int min, int max) {
//        HashSet<Integer> set = new HashSet<>();
//        int t = 0;
//        //使用滑动窗口
////        for (int r = 0;r < s.length();++r) {
////            t = t * 2 + (s.charAt(r) - '0');
////            if (r >= k) {
////                t -= (s.charAt(r - k) - '0') << k;
////            }
////            if (r >= k - 1 && t >= min && t <= max) {
////                set.add(t);
////            }
////        }
//
//        int left = 0, right = 0;
//        while (right < s.length() && right - left <= k) {
//            t = t * 2 + s.charAt(right) - '0';
//            ++right;
//            while (right - left >= k) {
//                if (right - left == k && t >= min && t <= max) {
//                    set.add(t);
//                }
//                t -= (s.charAt(left) - '0') << (right - left - 1);
//                ++left;
//            }
//        }
//        return set.size() == max - min + 1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
