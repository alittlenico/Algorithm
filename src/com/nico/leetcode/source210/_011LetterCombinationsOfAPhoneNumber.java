package com.nico.leetcode.source210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class _011LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        _011LetterCombinationsOfAPhoneNumber sol = new _011LetterCombinationsOfAPhoneNumber();
        System.out.println(sol.letterCombinations("23"));
    }

    //方法1 传参太多了 ... 好像是最佳 参数必须传
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return new ArrayList<>(0);
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if(index == digits.length()){//递归完一个字符 生成了一个字符串
            combinations.add(combination.toString());
        }else{
            char let = digits.charAt(index);
            String match = phoneMap.get(let);
            int len = match.length();
            for(int i = 0;i < len;i++){
                combination.append(match.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
