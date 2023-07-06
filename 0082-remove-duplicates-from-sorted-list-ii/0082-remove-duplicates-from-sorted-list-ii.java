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
        if(head == null || head.next == null)
            return head;

        TreeMap<Integer, ListNode> unique = new TreeMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        while(head != null){
            unique.put(head.val, head);
            if(count.get(head.val) == null)
                count.put(head.val, 0);
            count.put(head.val, count.get(head.val)+1);
            head = head.next;
        }

        ArrayList<ListNode> vals = new ArrayList<>();

        for(ListNode val : unique.values()){
            if(count.get(val.val) == 1)
                vals.add(val);
        }


        for(int i=0; i<vals.size(); i++){
            if(i == vals.size()-1)
                vals.get(i).next = null;
            else{
                vals.get(i).next = vals.get(i+1);
            }
        }
        if(vals.size() == 0)
            return null;
        return vals.get(0);
    }
}