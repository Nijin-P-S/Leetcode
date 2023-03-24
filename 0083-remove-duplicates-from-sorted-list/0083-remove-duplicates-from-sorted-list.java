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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode left = head;
        ListNode right = head;
        
        while(right != null){
            if(right.val != left.val){
                left.next = right;
                left = right;
            }
            right = right.next;
        }
        left.next = right;
        
        return head;
    }
}