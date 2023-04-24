/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public void neighborMapping(Node node, HashMap<Node, Node> map, int[] visited){
        if(node == null || visited[node.val] == 1)
            return;
        
        visited[node.val] = 1;
        List<Node> neighborList = new ArrayList<>();
        for(Node nei : node.neighbors){
            neighborList.add(map.get(nei));
            neighborMapping(nei, map, visited);
        }
        Node cur = map.get(node);
        cur.neighbors = neighborList;
    }
    
    public void mapping(Node node, HashMap<Node, Node> map){
        if(node == null)
            return;
        if(map.get(node)== null){
            map.put(node, new Node(node.val));
        }
        for(Node neighbor : node.neighbors){
            if(map.get(neighbor) == null)
                mapping(neighbor, map);
        }
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        int[] visited = new int[101];
        mapping(node, map);
        Arrays.fill(visited, 0);
        neighborMapping(node, map, visited);
        return map.get(node);
    }
}