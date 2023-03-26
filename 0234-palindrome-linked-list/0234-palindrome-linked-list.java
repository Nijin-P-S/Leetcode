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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        //Base condition : Check if head == null || head.next = null
        if(head == null || head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        prev.next = null;
        ListNode secHalf = reverse(slow);
        ListNode firHalf = head;
        while(firHalf != null && secHalf != null){
            if(firHalf.val != secHalf.val)
                return false;
            firHalf = firHalf.next;
            secHalf = secHalf.next;
        }
        return true;
    }
}