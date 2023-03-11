class Solution {
    //Using DP solution
//     private int paths(int m, int n, int i, int j, int[][] dp){
//         if(i==m-1 && j==n-1){
//             return 1;
//         }
        
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         } 
//         int numPaths = 0;
//         int downPath = 0;
//         int rightPath = 0;
//         if(i+1 < m){
//             downPath = paths(m, n, i+1, j, dp);
//         }
//         if(j+1 < n){
//             rightPath = paths(m, n, i, j+1, dp);
//         }
//         numPaths = downPath+rightPath;
//         return dp[i][j] = numPaths;
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++)
//                 dp[i][j] = -1;
//         }
        
//         return paths(m, n, 0, 0, dp);
//     }
    //Using Combinotrics
      public int uniquePaths(int m, int n){
          int N = m+n-2;
          int r = m-1;
          double res = 1;
          
          for(int i=1; i<=r; i++){
              res = res*(N-r+i)/i;
          }
          return (int) res;
      }
}