package com.nico.leetcode;

public class _165 {
    public static void main(String[] args) {
        _165 sol = new _165();
        int a = sol.compareVersion("0.1","1.1");
        System.out.println(a);
    }

    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int len1 = strs1.length;
        int len2 = strs2.length;
        int i = 0;int j = 0;
        while(i < len1 || j < len2){
            int a = 0;int b = 0;
            if(i < len1) a = Integer.parseInt(strs1[i++]);
            if(j < len2) b = Integer.parseInt(strs2[j++]);
            if(a != b){
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }
}
