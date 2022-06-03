package com.nico.leetcode.source210;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 8
 */
public class _016GenerateParentheses {
    /**
     * 暴力法：生成所有可能的括号序列，使用递归的方式去生成，长度为2n的序列，相当于在长度为
     * 2n-1的前面填上（ 或者 )。每生成一个括号序列，用valid方法判断是否有效，balance表示
     * 左括号数减去右括号数，每有一个右括号前面必先至少有一个左括号与之配对，遍历完序列的所有字符，
     * balance为0.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if(n == 1) return new ArrayList<String>(){{
            add("()");
        }};
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2*n],0,combinations);
        return combinations;
    }

    public void generateAll(char[] current,int pos,List<String> result){
        if(current.length == pos){
            if(valid(current)){
                result.add(new String(current));
            }
        }else{
            current[pos] = '(';
            generateAll(current,pos+1,result);
            current[pos] = ')';
            generateAll(current,pos+1,result);
        }
    }

    public boolean valid(char[] current){
        int balance = 0;
        for(char c : current){
            if(c == '(') ++balance;
            else --balance;
            if(balance < 0) return false;
        }
        return balance == 0;
    }

    /**
     * 回溯法：仅当当前字符有效时，才继续添加字符。
     * 当左括号数小于n时，可以添加左括号。当右括号数小于左括号时，可以添加左括号。
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        if(n == 1) return new ArrayList<String>(){{
            add("()");
        }};
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(),0,0,n);
        return result;
    }

    public void backtrack(List<String> result,StringBuilder sb,int left,int right,int max){
        if(sb.length() == 2*max){
            result.add(sb.toString());
        }else{
            if(left < max){
                sb.append('(');
                backtrack(result,sb,left+1,right,max);
                sb.deleteCharAt(sb.length()-1);
            }
            if(right < left){
                sb.append(')');
                backtrack(result,sb,left,right+1,max);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }


    //用斐波拉契数理解递归思想
    public static int fiberNumberTest(int n){
        if(n == 1 || n == 2) return 1;
        else{
            return fiberNumberTest(n-1) + fiberNumberTest(n-2);
        }
    }

    public static void main(String[] args) {
        _016GenerateParentheses sol = new _016GenerateParentheses();
        System.out.println(sol.generateParenthesis2(3));
//        StringBuilder sb = new StringBuilder();
//        sb.append('a');
//        sb.append('b');
//        sb.append('c');
//        System.out.println(sb.toString());
    }
}
