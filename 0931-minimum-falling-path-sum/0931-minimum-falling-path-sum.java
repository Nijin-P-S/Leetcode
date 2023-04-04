class Solution {
    
    private int minFall(int[][] matrix, int i, int j, int row, int col, int[][] dp){
        if(i== 0)
            return matrix[i][j];
        if(dp[i][j] != -1 )
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=-1; k<=1; k++){
            if(j+k >= 0 && j+k < col){
                min = Math.min(min, matrix[i][j] + minFall(matrix, i-1, j+k, row, col, dp));
            }
        }
        return dp[i][j] = min;
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)
                dp[i][j] = -1;
        }
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<col; i++){
             min = Math.min(min, minFall(matrix, row-1, i, row, col, dp));
        }
        return min;
    }
}