package com.nico.fushi.day0313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 将一个长度最多为30位数字的十进制非负整数转换为二进制数输出
 *  int -2147483648-2147483647
 */
public class Solution3 {
    public static void main(String[] args) throws Exception{
        Solution3 s = new Solution3();
        s.test();
    }

    public void test1(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while(x!=0){
            int n = x % 2 == 0 ? 0 : 1;
            x /= 2;
            list.add(n);
        }
        for(int i = list.size()-1;i >= 0 ;i--){
            System.out.print(list.get(i));
        }
    }

    public void test() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine())!=null) {
            BigInteger nstr = new BigInteger(str,10);
            String sss = nstr.toString(2);
            System.out.println(sss);
        }
    }
}
