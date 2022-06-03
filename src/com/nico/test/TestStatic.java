package com.nico.test;

public class TestStatic {
    static String a;

    public static String changeA(){
        a = new String("hello");
        return a;
    }

    public static void main(String[] args) {
        String str1 = TestStatic.changeA();
        String str2 = TestStatic.changeA();
        System.out.println(str1.equals(str2));
    }
}
