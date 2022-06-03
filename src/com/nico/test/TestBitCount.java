package com.nico.test;

import org.junit.Test;

public class TestBitCount {

    @Test
    public void test0(){
        int a = 7;
        int res = Integer.bitCount(a);
        System.out.println(res);
    }
}
