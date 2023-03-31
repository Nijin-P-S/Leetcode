class Solution {
    private int uniquePaths(int i, int j, int[][] dp){
        if(i==0 && j==0)
            return 1;
        if(dp[i][j] != 0)
            return dp[i][j];
        int left = 0, top = 0;
        if(i-1 >=0){
            top = uniquePaths(i-1, j, dp);
        }
        if(j-1 >=0){
            left = uniquePaths(i, j-1, dp);
        }
        return dp[i][j] = top+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<n; i++)
            dp[0][i] = 1;
        for(int j=0; j<m; j++)
            dp[j][0] = 1;
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                int top = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = top+left;
            }
        }
        return dp[m-1][n-1];
    }
}