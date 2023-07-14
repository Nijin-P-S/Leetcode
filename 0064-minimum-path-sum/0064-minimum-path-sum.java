class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];

        
        dp[0][0] = grid[0][0];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                if(i==0 && j==0)
                    continue;
                int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
                if(j-1 >= 0)
                    left = dp[i][j-1]+ grid[i][j];
                if(i-1 >= 0)
                    top = dp[i-1][j]+ grid[i][j];

                dp[i][j] = Math.min(left, top);
            }
        }
        
        return dp[m-1][n-1];
    }
}