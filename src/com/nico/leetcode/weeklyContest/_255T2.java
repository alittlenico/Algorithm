package com.nico.leetcode.weeklyContest;

import java.util.HashSet;

public class _255T2 {
    public static void main(String[] args) {
        _255T2 sol = new _255T2();
        System.out.println(sol.findDifferentBinaryString(new String[]{"01","10"}));
    }

    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int n = nums.length;
        for(String str : nums){
            int res = 0;
            char[] arr = str.toCharArray();
            for(int i = 0;i < arr.length;++i){
                if(arr[i] == '1'){
                    res += 1 << (arr.length - 1 - i);
                }
            }
            hs.add(res);
        }
        for(int i = 0;i < 1 << n;++i){
            if(!hs.contains(i)){
                String str = Integer.toBinaryString(i);
                if(str.length() != n){
                    String temp = "";
                    for(int j = 1;j <= n - str.length();++j){
                        temp += "0";
                    }
                    str = temp + str;
                }
                return str;
            }
        }
        return "";
    }
}
