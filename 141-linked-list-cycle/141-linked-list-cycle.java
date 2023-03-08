/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> uni = new HashSet<>();
        
        while(head != null){
            if(uni.contains(head))
                return true;
            uni.add(head);
            head = head.next;
        }
        return false;
        
    }
}