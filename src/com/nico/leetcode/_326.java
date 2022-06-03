package com.nico.leetcode;

import org.junit.Test;

public class _326 {
    public static void main(String[] args) {
        _326 sol = new _326();
        boolean res = sol.isPowerOfThree(2147483647);
        System.out.println(res);
    }

    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        int x = 1;
        while(x < n) x *= 3;
        return x == n;
    }


    @Test
    public void test(){
        //32bit 最大3的幂
//        1162261467 1162261467
        long x = 1;
        int pow = 0;
        while(x < (1 << 31) - 1){
            x *= 3;
            ++pow;
        }
        System.out.println(x / 3);
        System.out.println(pow - 1);
    }
}
