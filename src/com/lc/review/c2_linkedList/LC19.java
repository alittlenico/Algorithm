package com.lc.review.c2_linkedList;

import com.lc.review.ListNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/18 20:44
 */
public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        /**
         * 用两个指针一趟遍历链表,
         * l2指针先向后遍历n个位置，
         * l1和l2一起向后遍历，直到l2到链表末尾，
         * 此时l1为待删除元素的前一个
         */
        //使用带头指针的链表
        ListNode h1 = new ListNode();
        h1.next = head;
        ListNode l1,l2;
        l1 = l2 = h1;
        for(int i=0;i<n;i++){
            if(l2.next != null){
                l2 = l2.next;
            }else{//删除位置不合理
                return null;
            }
        }
        while(l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = l1.next.next;
        return h1.next;
    }
}
