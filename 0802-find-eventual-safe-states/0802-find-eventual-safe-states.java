class Solution {
    public boolean dfs(int[][] graph, int node, int[] vis, int[] pathVis, int[] check){
        check[node] = 0;
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int adj : graph[node]){
            if(vis[adj] == 0){
                if(dfs(graph, adj, vis, pathVis, check))
                    return true;
            }
            else if(pathVis[adj] == 1)
                return true;
        }
        pathVis[node] = 0;
        check[node] = 1;
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] pathVis = new int[graph.length];
        int[] check = new int[graph.length];
        
        
        for(int i=0; i<graph.length; i++){
            if(vis[i] == 0){
                dfs(graph, i, vis, pathVis, check);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<graph.length; i++)
            if(check[i] == 1)
                ans.add(i);
        
        return ans;
        
    }
}