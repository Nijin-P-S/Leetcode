class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] first = new int[col];
        for(int i=0; i<col; i++){
                first[i] = matrix[0][i];
        }
        
        for(int i=1; i<row; i++){
            int[] cur = new int[col];
            for(int j=0; j<col; j++){
                int min = Integer.MAX_VALUE;
                 for(int k=-1; k<=1; k++){
                    if(j+k >= 0 && j+k < col){
                        min = Math.min(min, matrix[i][j] + first[j+k]);
                    }
                }
                cur[j] = min;
            }
            first = cur;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<col; i++){
             min = Math.min(min, first[i]);
        }
        return min;
    }
}