/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private void reverse(ListNode par, ListNode cur){
        if(cur == null)
            return;
        
        reverse(cur, cur.next);
        cur.next = par;
        return;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode tail = head;
        while(tail.next != null)
            tail = tail.next;
        reverse(null, head);
        return tail;
    }
}