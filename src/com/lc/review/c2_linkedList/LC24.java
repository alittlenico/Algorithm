package com.lc.review.c2_linkedList;

import com.lc.review.ListNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @date 2022/8/6 10:05
 */
public class LC24 {
    public ListNode swapPairs(ListNode head) {
        //终止条件
        if(head == null || head.next == null) return head;
        ListNode one = head;
        ListNode two = head.next;
        ListNode three = swapPairs(two.next);
        two.next = one;
        one.next = three;
        return two;
    }
}
