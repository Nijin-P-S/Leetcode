class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(matrix[i][j] == '1'){
                    int right = j+1<n ? dp[i][j+1] : 0;
                    int down = i+1 < m ? dp[i+1][j] : 0;
                    int diag = (i+1 < m ) && (j+1 < n) ? dp[i+1][j+1] : 0;
                    dp[i][j] = 1+Math.min(right, Math.min(down, diag));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
       
        return max*max;
    }
}