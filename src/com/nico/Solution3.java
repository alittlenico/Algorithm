package com.nico;

import java.util.ArrayList;

public class Solution3 {
    public static void main(String[] args) {
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            //每次添加 把元素向后移动
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }
}
