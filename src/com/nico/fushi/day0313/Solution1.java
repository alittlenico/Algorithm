package com.nico.fushi.day0313;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        Map<Integer,Integer> stus = new HashMap<>();
        for(int i=0;i<num;i++){
            String temp = sc.nextLine();
            String[] str = temp.split(" ");
            stus.put(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
        List<Map.Entry<Integer,Integer>> stuList = new ArrayList<Map.Entry<Integer,Integer>>(stus.entrySet());
        Collections.sort(stuList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(int i=0;i<stuList.size();i++){
            String[] s = (stuList.get(i)+"").split("=");
            System.out.println(s[0]+" "+s[1]);
        }
    }


}
