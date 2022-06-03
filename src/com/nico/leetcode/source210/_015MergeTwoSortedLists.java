package com.nico.leetcode.source210;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in both lists is in the range [0, 50].
 *     -100 <= Node.val <= 100
 *     Both l1 and l2 are sorted in non-decreasing order.
 *
 */
public class _015MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //不带头结点
        ListNode _head = new ListNode();
        ListNode head = _head;
        //取两个链表的第一个元素
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1!=null){
            head.next = l1;
        }
        if(l2!=null){
            head.next =l2;
        }
        return _head.next;
    }
}
