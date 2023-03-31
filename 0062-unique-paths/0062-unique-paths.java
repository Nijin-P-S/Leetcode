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
        return uniquePaths(m-1, n-1, dp);
    }
}