/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node prev = null;
        HashMap<Node, Node> map = new HashMap<>();
        Node tail = head;
        while(tail != null){
            if(map.get(tail) == null){
                Node newNode = new Node(tail.val);
                map.put(tail, newNode);
            }
            if(prev == null){
                prev = map.get(tail);
            }
            else{
                prev.next = map.get(tail);
                prev = prev.next;
            }
            tail = tail.next;
        }
        
        tail = head;
        while(tail != null){
            if(map.get(tail.random) == null){
                if(tail.random == null)
                    map.put(tail.random, null);
                else{
                    Node newNode = new Node(tail.random.val);
                    map.put(tail.random, newNode);
                }    
            }
            Node curNode = map.get(tail);
            curNode.random = map.get(tail.random);
            tail = tail.next;
        }
        return map.get(head);
    }
}