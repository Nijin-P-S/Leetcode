class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i=0; i<col; i++){
                dp[0][i] = matrix[0][i];
        }
        
        for(int i=1; i<row; i++){
            for(int j=0; j<col; j++){
                int min = Integer.MAX_VALUE;
                 for(int k=-1; k<=1; k++){
                    if(j+k >= 0 && j+k < col){
                        min = Math.min(min, matrix[i][j] + dp[i-1][j+k]);
                    }
                }
                dp[i][j] = min;
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<col; i++){
             min = Math.min(min, dp[row-1][i]);
        }
        return min;
    }
}