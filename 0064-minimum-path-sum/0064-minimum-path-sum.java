class Solution {
    private int minPathSum(int[][] grid, int i, int j, int[][] dp){
        if(i==0 && j==0)
            return grid[i][j];

        if(dp[i][j] != -1)
            return dp[i][j];
        
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
        
        if(j-1 >= 0)
            left = minPathSum(grid, i, j-1, dp)+ grid[i][j];
        if(i-1 >= 0)
            top = minPathSum(grid, i-1, j, dp)+ grid[i][j];
        
        return dp[i][j] = Math.min(left, top);
    }
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                dp[i][j] = -1;
        }
        
        return minPathSum(grid, m-1, n-1, dp);
    }
}