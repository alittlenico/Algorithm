package com.nico.fushi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=reader.readLine())!=null){
            char[] temp = str.toCharArray();
            for(int i=0;i<2;i++){
                char temp1 = temp[3-i];
                temp[3-i]=temp[i];
                temp[i]=temp1;
            }
            String out = new String(temp);
            System.out.println(out);
        }
    }

}
