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
        int lengthA = 0, lengthB = 0;
        
        ListNode dummyA = headA, dummyB = headB;
        
        while(dummyA != null){
            lengthA++;
            dummyA = dummyA.next;
        }
        
        while(dummyB != null){
            lengthB++;
            dummyB = dummyB.next;
        }
        
        boolean AorB = lengthA > lengthB;
        dummyA = headA;
        dummyB = headB;
        
        if(AorB){
            for(int i=0; i<lengthA-lengthB; i++)
                dummyA = dummyA.next;
        }
        else{
            for(int i=0; i<lengthB-lengthA; i++)
                dummyB = dummyB.next;
        }
        
        
        while(dummyA != null && dummyB != null){
            if(dummyA == dummyB)
                return dummyA;
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        
        return null;
        
    }
}