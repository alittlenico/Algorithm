package com.nico.offer2;

import org.junit.Test;

public class _014 {

    @Test
    public void test0(){
        System.out.println(cuttingRope(999));
    }

    public long cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
