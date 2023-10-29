class Solution {
    private void dfs(List<List<Integer>> rooms, boolean[] vis, int cur){
        vis[cur] = true;
        
        for(Integer key : rooms.get(cur)){
            if(!vis[key])
                dfs(rooms, vis, key);
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        
        boolean vis[] = new boolean[size];
        
        dfs(rooms, vis, 0);
        
        for(boolean cur : vis)
            if(cur == false)
                return false;
        return true;
    }
}