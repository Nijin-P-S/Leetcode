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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null && curr.next != null){
            ListNode nxtPtr = curr.next.next;
            ListNode second = curr.next;
            
            second.next = curr;
            curr.next = nxtPtr;
            prev.next = second;
            
            prev = curr;
            curr = nxtPtr;
        }
        return dummy.next;
    }
}