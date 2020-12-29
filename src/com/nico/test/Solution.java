package com.nico.test;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(FirstNotRepeatingChar("gzogle"));
        Map maps = new HashMap<Character,Integer>();
        maps.put('a',1);
        maps.put('a',2);
        System.out.println(maps);
    }
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一
     * 次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     */
    public static int FirstNotRepeatingChar(String str) {
        Map maps = new HashMap<Character, Integer>();
        char[] chr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for(int i=0;i<chr.length;i++){
            maps.put(chr[i],0);
        }
        for(int i=0;i<str.length();i++){
            char key = str.charAt(i);
            Integer count = (Integer) maps.get(key);
            count++;
            maps.remove(key);
            maps.put(key,count);
        }
        Iterator iterator = maps.entrySet().iterator();
        Set<Character> set = new HashSet();
        while (iterator.hasNext()){
            Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>)iterator.next();
            if(entry.getValue()==1){//出现次数为1
                set.add(entry.getKey());
            }
        }
        if(set.size()==0){
            return -1;
        }
        int min = -1;//记录最小下标
        Iterator<Character> iteratorSet = set.iterator();
        if(iteratorSet.hasNext()){
            min = str.indexOf(iteratorSet.next()+"");//set中第一个元素的下标
            while (iteratorSet.hasNext()){
                Character c1 = iteratorSet.next();
                if(str.indexOf(c1+"")<min){
                    min = str.indexOf(c1+"");
                }
            }
        }
        return min;
    }
//    升级版
    public static int FirstNotRepeatingChar1(String str){
        if(str==null) return -1;
        int length = str.length();
        Map map = new HashMap<Character,Integer>();
        for(int i = 0;i < length;i++){
            Character key = str.charAt(i);
            if(map.containsKey(key)){
                int value = (Integer) map.get(key) + 1;
                map.put(key,value);
            }else{
                map.put(key,1);
            }
        }
        for(int i = 0;i < length;i++){
            if((Integer) map.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
