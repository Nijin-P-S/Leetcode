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
    /*
    * HashSet Approach
    */
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashSet<ListNode> inter = new HashSet<>();
        
//         while(headA != null){
//             inter.add(headA);
//             headA = headA.next;
//         }
        
//         while(headB != null){
//             if(inter.contains(headB))
//                 return headB;
//             headB = headB.next;
//         }
//         return null;
//     }
    
    /*
    * Optimal approach using two dummy pointers
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}