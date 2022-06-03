package com.nico.leetcode.source210;

/**
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _013RemoveNthNodeFromEndOfList {

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

    public static void main(String[] args) {
        //初始化链表
        int[] arr = new int[]{1,2};
        ListNode head = new ListNode(arr[0]);
        ListNode _head = head;
        for(int i=1;i<arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            _head.next = node;
            _head = _head.next;
        }
        _013RemoveNthNodeFromEndOfList sol = new _013RemoveNthNodeFromEndOfList();
        ListNode result = sol.removeNthFromEnd(head,2);
        //遍历链表
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }

}
