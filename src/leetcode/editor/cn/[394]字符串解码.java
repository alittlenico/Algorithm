package leetcode.editor.cn;//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1448 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution394 {
    int ptr = 0;
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        for (;ptr < s.length();) {
            char c = s.charAt(ptr);
            if (Character.isDigit(c)) {
                stack.addFirst(getDigit(s));
            } else if (Character.isLetter(c) || '[' == c) {
                stack.addFirst(String.valueOf(c));
                ptr++;
            }else {
                List<String> strs = new ArrayList<>();
                while (!"[".equals(stack.peekFirst())) {
                    strs.add(String.valueOf(stack.removeFirst()));
                }
                Collections.reverse(strs);
                //移除 [
                stack.removeFirst();
                int repNum = Integer.parseInt(stack.removeFirst());
                String str = getStr(strs);
                StringBuilder sb =  new StringBuilder();
                for (;repNum > 0;repNum--) {
                    sb.append(str);
                }
                stack.addFirst(sb.toString());
                ptr++;
            }
        }
        Collections.reverse(stack);
        return getStr(stack);
    }

    public String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr));
            ptr++;
        }
        return sb.toString();
    }

    public String getStr(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
