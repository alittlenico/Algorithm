package com.lc.review.c3_str;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。1
 * @date 2022/8/6 9:22
 */
public class LC20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) return false;
        Set<Character> set = new HashSet<Character>(){{
            add('(');
            add('{');
            add('[');
        }};
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (char c : chars) {
            if (set.contains(c)) {
                stack.push(c);
            }else {
                Character peek = stack.peek();
                if (peek == null || !map.get(c).equals(peek)) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.size() > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        char c = '1';
        Set<Character> set = new HashSet<Character>(){{
            add('1');
            add('{');
            add('[');
        }};
        Character c1 = '1';
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('1', '1');
        }};
        System.out.println(map.get('1').equals(c1));
        System.out.println(set.contains(c));
    }
}
