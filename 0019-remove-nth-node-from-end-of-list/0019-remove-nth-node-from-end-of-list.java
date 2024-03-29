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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode tail = head;
        
        while(tail != null){
            length++;
            tail = tail.next;
        }
        
        if(length-n == 0)
            return head.next;
        
        tail = head;
        for(int i=1; i<(length-n); i++){
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return head;
    }
}