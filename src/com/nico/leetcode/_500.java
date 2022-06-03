package com.nico.leetcode;

import java.util.*;

public class _500 {
    public static void main(String[] args) {
        _500 sol = new _500();
        sol.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }

    public String[] findWords(String[] words) {
        String str1 = "qwertyuiop";String str2 = "asdfghjkl";String str3 = "zxcvbnm";
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        for(int i = 0;i < str1.length();++i) set1.add(str1.charAt(i));
        for(int i = 0;i < str2.length();++i) set2.add(str2.charAt(i));
        for(int i = 0;i < str3.length();++i) set3.add(str3.charAt(i));
        List<String> list = new ArrayList<>();
        for(String str : words){
            String _str = new String(str);
            str.toLowerCase();
            char c = str.charAt(0);
            boolean flag = true;
            if(set1.contains(c)){
                for(int i = 1;i < str.length();++i){
                    if(!set1.contains(str.charAt(i))){
                        flag = false;
                        break;
                    }
                }
            }else if(set2.contains(c)){
                for(int i = 1;i < str.length();++i){
                    if(!set2.contains(str.charAt(i))){
                        flag = false;
                        break;
                    }
                }
            }else{
                for(int i = 1;i < str.length();++i){
                    if(!set3.contains(str.charAt(i))){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) list.add(_str);
        }
        return list.toArray(new String[list.size()]);
    }
}
