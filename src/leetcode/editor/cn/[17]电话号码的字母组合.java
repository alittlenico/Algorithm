package leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2466 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {

    List<String> res = new ArrayList<>();
    //使用map.of初始化:
    /**
     * static final Map<Character, String> map = Map.of(
     *         '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
     *         '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
     *     );
     */
    static Map<Character, String> map = new HashMap<Character, String>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    int n;

    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if (n == 0) return res;
        dfs(0, "", digits);
        return res;
    }

    private void dfs(int i, String cur,String digits) {
        if (i == n) {
            res.add(cur);
            return;
        }
        char c = digits.charAt(i);
        String s = map.get(c);
        for (char x : s.toCharArray()) {
            dfs(i + 1, cur + x, digits);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
