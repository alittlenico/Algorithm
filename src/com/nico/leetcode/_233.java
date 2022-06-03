package com.nico.leetcode;

public class _233 {
    public static void main(String[] args) {
        _233 sol = new _233();
        sol.countDigitOne(12);
    }

    public int countDigitOne(int n) {
        int res = 0;
        for(int i = 1;i <= n;i *= 10){
            int x = n % i;
            res = res + (n/(i*10)*i) + Math.min(Math.max(x - i + 1,0),i);
        }
        return res;
    }
}
