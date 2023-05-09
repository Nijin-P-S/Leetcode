class Solution {
    private void dfs(int city, HashSet<List<Integer>> edges, HashMap<Integer, List<Integer>> neighbors, HashSet<Integer> visited, int[] changes){
        for(Integer neighbor : neighbors.get(city)){
            if(visited.contains(neighbor))
                continue;
            List<Integer> currEdge = new ArrayList<>();
            currEdge.add(neighbor);
            currEdge.add(city);
            if(!edges.contains(currEdge))
                changes[0]++;
            visited.add(neighbor);
            dfs(neighbor, edges, neighbors, visited, changes);
        }
    }
    
    public int minReorder(int n, int[][] connections) {
        //Creating the hashset of the edges
        HashSet<List<Integer>> edges = new HashSet<>();
        for(int i=0; i<connections.length; i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(connections[i][0]);
            curr.add(connections[i][1]);
            edges.add(curr);
        }
        
        //Create a hashMap of the neighbors
        HashMap<Integer, List<Integer>> neighbors = new HashMap<>();
        
        for(List<Integer> edge : edges){
            int a = edge.get(0);
            int b = edge.get(1);
            
            if(neighbors.get(a) == null){
                neighbors.put(a, new ArrayList<>());
            }
            if(neighbors.get(b) == null){
                neighbors.put(b, new ArrayList<>());
            }
            List<Integer> aNeighbors = neighbors.get(a);
            List<Integer> bNeighbors = neighbors.get(b);
            aNeighbors.add(b);
            bNeighbors.add(a);
            neighbors.put(a, aNeighbors);
            neighbors.put(b, bNeighbors);
        }
        
        //Create a Hashset to keep the count of visited cities
        HashSet<Integer> visited = new HashSet<>();
        
        visited.add(0);
        int[] changes = new int[1];
        dfs(0, edges, neighbors, visited, changes);
        
        return changes[0];
    }
}