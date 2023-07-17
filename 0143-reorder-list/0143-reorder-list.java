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
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = head.next;
        
        while(cur != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next!= null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode headSec = reverse(slow);
        
        ListNode one = headSec, two = head;
         
        ListNode temp = head;
        prev = null;
        while(temp != null && headSec != null){
            prev = headSec;
            ListNode nextFirst = temp.next;
            ListNode nextSec = headSec.next;
            temp.next = headSec;
            headSec.next = nextFirst;
            temp = nextFirst;
            headSec = nextSec;
        }
        
        if(headSec != null){
            prev.next = headSec;
        }
            

        
        return;
    }
}