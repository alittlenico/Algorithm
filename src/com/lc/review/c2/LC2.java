package com.lc.review.c2;

import com.lc.review.ListNode;

/**
 * @author liuyi
 * @version 1.0
 * @description: 逆链表相加
 * @date 2022/6/21 11:20
 */
public class LC2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     *
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //返回值依然是逆序
        ListNode head = null;//头指针
        ListNode tail = null;//尾指针
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            //初始化 后面不断建新节点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //进位
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
