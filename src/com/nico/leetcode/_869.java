package com.nico.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _869 {
    public static void main(String[] args) {
        _869 sol = new _869();
        sol.reorderedPowerOf2(1042);
    }


    Map<Integer,Integer> map = new HashMap<>();
    int uniqueCount;//可填的数字
    int[][] infoArr;
    int Allcount;
    int _size;
    boolean flag = false;
    public boolean reorderedPowerOf2(int n) {
        //先判断本身
        if(check(n)) return true;
        getNumber(n);
        int size = Allcount;
        _size = size - 2;//首尾数字先确定
        infoArr = new int[uniqueCount][2];
        //遍历map 有二维数组来存储数字的各位上的数 及有多少位
        int idx = 0;
        for(Integer key : map.keySet()){
            infoArr[idx][0] = key;
            infoArr[idx][1] = map.get(key);
            ++idx;
        }
        //用字符数组构建该字符串的一个组合
        char[] numCharArr = new char[size];
        for(int i = 0;i < uniqueCount;++i){
            if(infoArr[i][1] > 0 && infoArr[i][0] != 0){
                numCharArr[0] = (char)(infoArr[i][0] + 48);
                --infoArr[i][1];
            }else continue;
            for(int j = 0; j < uniqueCount;++j){
                if(infoArr[j][1] > 0 && infoArr[j][0] % 2 == 0){
                    numCharArr[size-1] = (char)(infoArr[j][0] + 48);
                    --infoArr[j][1];
                    dfs(numCharArr,1);
                    ++infoArr[j][1];
                }else continue;
            }
            ++infoArr[i][1];
        }
        return flag;
    }

    void dfs(char[] arr,int position){//遍历完所有数字组合
        if(position > _size){
            String numStr = new String(arr);
            int testNum = Integer.parseInt(numStr);
            System.out.println(testNum);
            if(check(testNum)) flag = true;
            return;
        }
        for(int i = 0;i < uniqueCount && !flag;++i){
            if(infoArr[i][1] > 0){
                arr[position] = (char)(infoArr[i][0] + 48);
                --infoArr[i][1];
                dfs(arr,position+1);
                ++infoArr[i][1];
            }
        }
    }

    void getNumber(int x){
        while(x > 0){
            int temp = x % 10;
            if(map.containsKey(temp)){
                map.computeIfPresent(temp,(k,v)->v+1);
            }else{
                map.put(temp,1);
                ++uniqueCount;
            }
            x /= 10;
            ++Allcount;
        }
    }

    boolean check(int x){
        while(x > 1){
            if(x % 2 != 0) return false;
            x /= 2;
        }
        return true;
    }
}
