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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while(l1 != null && l2 != null){
            sum = carry+l1.val+l2.val;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            sum = carry + l1.val;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            carry = sum/10;
            l1 = l1.next;
        }
        while(l2 != null){
            sum = carry + l2.val;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            carry = sum/10;
            l2 = l2.next;
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
}