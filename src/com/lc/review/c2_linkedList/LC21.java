package com.lc.review.c2_linkedList;

import com.lc.review.ListNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: 1.不破坏入参数据
 * 2.使用头节点
 * @date 2022/8/6 9:57
 */
public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = list1, temp2 = list2;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null) {
            temp.next = temp1;
        }else if(temp2 != null){
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
