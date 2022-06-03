package com.nico.leetcode.source210;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *  
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _014ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()%2 == 0){
            Stack<Character> stack = new Stack<>();
            for(int i =0;i<s.length();i++){
                Character c = s.charAt(i);
                if((c == '[') || (c == '{') || (c == '(')){//是左括号压入栈顶
                    stack.push(c);
                }else{
                    //判断栈是否为空
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        Character popC = stack.pop();
                        switch (c){
                            case ')' : c = '(';
                                break;
                            case ']' : c = '[';
                                break;
                            case '}' : c = '{';
                                break;
                        }
                        if( popC == c){
                            continue;
                        }else {return false;}
                    }
                }
            }
            if(stack.isEmpty()){
                return true;
            }else{//左括号单身
                return false;
            }
        }
        return false;
    }
    public boolean isValid2(String s) {
        int n = s.length();
        if(n%2 !=0) return false;
        Map<Character,Character> pairs = new HashMap<Character,Character>(){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            if(pairs.containsKey(c)){//右括号
                if(stack.isEmpty() || stack.peek() != pairs.get(c)){//栈非空空 或者 不匹配
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _014ValidParentheses sol = new _014ValidParentheses();
        System.out.println(sol.isValid("()"));
        System.out.println(sol.isValid("([)]"));
    }

}
