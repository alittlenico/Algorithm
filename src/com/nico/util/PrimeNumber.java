package com.nico.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumber sol = new PrimeNumber();
        System.out.println(sol.getAllPrimeFactor(6));
    }

    List<Integer> getAllPrimeFactor2(int n){
        List<Integer> res = new ArrayList<>();
        for(int i = 2;i <= n;){
            if(n % i == 0){
                res.add(i);
                n /= i;
            }else{
                ++i;
            }
        }
        return res;
    }

    List<Integer> getAllPrimeFactor(int n){
        List<Integer> res = new ArrayList<>();
        for(int i = 2;i <= Math.sqrt(n) + 1;++i){
            if(checkIsPrimeNumber(i) && n % i == 0){
                res.add(i);
            }
        }
        return res;
    }

    boolean checkIsPrimeNumber(int n){
        int flag = (int)Math.sqrt(n);
        for(int i = 2;i < flag;++i){
            if(n % i == 0) return false;
        }
        return true;
    }
}
