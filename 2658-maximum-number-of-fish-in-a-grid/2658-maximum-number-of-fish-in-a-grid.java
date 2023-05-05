class Solution {
    public static int dfs(int[][] grid, int i, int j, int n, int m, int[][] vis){
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j] == 1 || grid[i][j]==0)
            return 0;
        vis[i][j] = 1;

        int left = dfs(grid, i, j-1, n, m, vis);
        int right =  dfs(grid, i, j+1, n, m, vis);
        int top = dfs(grid, i-1, j, n, m, vis);
        int down = dfs(grid, i+1, j, n, m, vis);

        return left+right+top+down+grid[i][j];
    }
    public int findMaxFish(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] >0 && vis[i][j] != 1){
                    max = Math.max(max, dfs(grid, i, j, n, m, vis));
                }
            }

        }
        return max;
    }
}