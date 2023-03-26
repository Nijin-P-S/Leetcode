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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        //Find length of LL
        int length = 0;
        ListNode curr = head;
        while(curr != null)
        {
            length++;
            curr = curr.next;
        }
        k = k%length;
        if(k == 0)
            return head;
        int toMove = length-k-1;
        curr = head;
        while(toMove > 0){
            toMove--;
            curr = curr.next;
        }
        ListNode oldHead = head;
        head = curr.next;
        curr.next = null;
        
        ListNode tail = head;
        while(tail.next != null)
            tail = tail.next;
        tail.next = oldHead;
        return head;
    }
}