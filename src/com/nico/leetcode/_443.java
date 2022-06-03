package com.nico.leetcode;

public class _443 {

    public static void main(String[] args) {
        _443 sol = new _443();
        sol.compress(new char[]{'a','b','c'});
    }

    public int compress(char[] chars) {
        int n = chars.length;
        if(n == 1) return 1;
        char pre = ' ';int count = 0;int idx = 0;
        for(int i = 0;i < n;++i){
            if(i == 0) {
                pre = chars[i];count = 1;
            }
            else{
                if(pre != chars[i]){
                    chars[idx++] = pre;
                    if(count == 1){
                    }else if(count > 1 && count < 10){
                        chars[idx++] = String.valueOf(count).toCharArray()[0];
                    }else{
                        String str = String.valueOf(count);
                        char[] cs = str.toCharArray();
                        for(char c : cs){
                            chars[idx++] = c;
                        }
                    }
                    pre = chars[i];
                    count = 1;
                }else{
                    ++count;
                }
            }
        }
        if(count == 1){
            chars[idx++] = pre;
        }else{
            chars[idx++] = pre;
            if(count > 1 && count < 10){
                chars[idx++] = String.valueOf(count).toCharArray()[0];
            }else{
                String str = String.valueOf(count);
                char[] cs = str.toCharArray();
                for(char c : cs){
                    chars[idx++] = c;
                }
            }
        }
        return idx;
    }
}
