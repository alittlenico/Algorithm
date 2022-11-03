package com.nico.leetcode;

//import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;

public class _692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int count = 0;
        for(String str : words){
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
        //对value排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //转换为list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return  o2.getValue() == o1.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i=0;i < k;i++){
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        _692 sol = new _692();
        System.out.println(sol.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
        System.out.println(sol.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
    }
}
