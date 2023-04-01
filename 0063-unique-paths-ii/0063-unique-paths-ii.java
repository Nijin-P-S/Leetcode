class Solution {
//     private int uniquePaths(int[][] obstacleGrid, int i, int j, int[][] dp){
//         if(i == 0 && j == 0)
//             return 1;
//         if(i < 0 || j < 0)
//             return 0;
//         if(obstacleGrid[i][j] == 1)
//             return 0;
        
//         if(dp[i][j] != -1)
//             return dp[i][j];
//         int left = uniquePaths(obstacleGrid, i, j-1, dp);
//         int top = uniquePaths(obstacleGrid, i-1, j, dp);
//         return dp[i][j] = left + top;
//     }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == 0 && j == 0)
                    dp[i][j] = 1;
                else{
                    int left = j>0 ? dp[i][j-1] : 0;
                    int top = i>0 ? dp[i-1][j] : 0;
                    dp[i][j] = left + top;
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}