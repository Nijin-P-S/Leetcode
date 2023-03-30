class Solution {
    private void dfs(ArrayList<ArrayList<Integer>> adjList, int[] vis, int i){
        vis[i] = 1;
        
        for(int node : adjList.get(i)){
            if(vis[node] == 0){
                dfs(adjList, vis, node);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int vis[] = new int[isConnected.length];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<isConnected.length; i++){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1)
                    curr.add(j);
            }
            adjList.add(curr);
        }
        int ans = 0;
        for(int i=0; i<isConnected.length; i++){
            if(vis[i] == 0){
                ans++;
                dfs(adjList, vis, i);
            }
        }
        
        return ans;
    }
}