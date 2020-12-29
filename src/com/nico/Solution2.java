package com.nico;

public class Solution2 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello  world!");
        System.out.println(replaceSpace2(str));
    }

    public static String replaceSpace(StringBuffer str) {
        if(str.length()==0) return "";
        int len = str.length();
        int curLen = len;
        for(int i=0;i<curLen;i++){
            if(str.charAt(i)==' '){
                str.replace(i,i+1,"%20");
                i=i+2;
                curLen=curLen+2;
            }
        }
        return str.toString();
    }

    public static String replaceSpace2(StringBuffer str){
        if(str.length()==0) return "";
        return str.toString().replaceAll("\\s","%20");
    }
}
