/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode dummyA = headA, dummyB = headB;
        
        
        while(dummyA != null && dummyB != null){
            if(dummyA == dummyB)
                return dummyA;
            dummyA = dummyA.next;
            dummyB = dummyB.next;
            
            if(dummyA == null && dummyB == null)
                break;
            else if(dummyA == null)
                dummyA = headB;
            else if(dummyB == null)
                dummyB = headA;
        }
        return null;
    }
}