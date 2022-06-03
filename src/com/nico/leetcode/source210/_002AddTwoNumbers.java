package com.nico.leetcode.source210;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _002AddTwoNumbers {

    public static void main(String[] args) {

        int[] arr1 = new int[]{2,3,4};
        int[] arr2 = new int[]{5,6,4};

        ListNode l1 = initializeListNode(arr1);
        ListNode l2 = initializeListNode(arr2);
        _002AddTwoNumbers sol = new _002AddTwoNumbers();
        ListNode result = sol.addTwoNumbers2(l1,l2);
    }

    public static ListNode initializeListNode(int[] arr){//用数组初始化一个链表
        ListNode l1 = new ListNode(arr[0]);
        ListNode _l1 = l1;
        for(int i = 1;i<arr.length;i++){
            _l1.next = new ListNode(arr[i]);
            _l1 = _l1.next;
        }
        return l1;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;//头指针
        ListNode tail = null;//尾指针
        int carry = 0;//进位
        while(l1 != null || l2 != null){//循环结束条件两个链表都为空
            //为空节点 val 看作 0
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //有进位添加新节点
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
