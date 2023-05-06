class Solution {
    public void dfs(int[][] heights, int i, int j, int m, int n, HashSet<List<Integer>> vis){
        List<Integer> cur = new ArrayList<>();
        cur.add(i);
        cur.add(j);
        if(vis.contains(cur)){
            return;
        }
        vis.add(cur);
        if(i-1 >= 0 && heights[i][j] <= heights[i-1][j])
            dfs(heights, i-1, j,m,n, vis);
        if(i+1 < m  && heights[i][j] <= heights[i+1][j])
            dfs(heights, i+1, j,m,n, vis);
        if(j-1 >= 0 && heights[i][j] <= heights[i][j-1])
            dfs(heights, i, j-1,m,n, vis);
        if(j+1 < n && heights[i][j] <= heights[i][j+1])
            dfs(heights, i, j+1,m,n, vis);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        HashSet<List<Integer>> pac = new HashSet<>();
        HashSet<List<Integer>> atl = new HashSet<>();
        
        int m = heights.length;
        int n = heights[0].length;
        for(int i=0; i<n; i++){
            dfs(heights, 0, i,m,n, pac);
            dfs(heights, m-1, i,m,n, atl);
        }
        for(int i=0; i<m; i++){
            dfs(heights, i, 0,m,n, pac);
            dfs(heights, i, n-1,m,n, atl);
        }
        List<List<Integer>> ans= new ArrayList<>();
        for(List<Integer> val : pac){
            if(atl.contains(val))
                ans.add(val);
        }
        return ans;
    }
}