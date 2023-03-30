class Solution {
    private void dfs(int[][] isConnected, int[] vis, int i){
        vis[i] = 1;
        
        for(int j=0; j<isConnected[0].length; j++){
            if(isConnected[i][j] == 1 && vis[j] == 0){
                dfs(isConnected, vis, j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int vis[] = new int[isConnected.length];        
        int ans = 0;
        for(int i=0; i<isConnected.length; i++){
            if(vis[i] == 0){
                ans++;
                dfs(isConnected, vis, i);
            }
        }
        return ans; 
    }
}