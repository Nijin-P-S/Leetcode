class NumMatrix {
    int[][] matrix;
    int[][] prefixSumMatrix;
    
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        prefixSumMatrix = new int[row][col];
        this.matrix = matrix;
        setPrefixSumMatrix(this.matrix, prefixSumMatrix, row, col);
    }
    
    private void setPrefixSumMatrix(int[][] matrix, int[][] prefixSumMatrix, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int sum = matrix[i][j];
                if(i-1 >= 0)
                    sum+= prefixSumMatrix[i-1][j];
                if(j-1 >= 0)
                    sum+=prefixSumMatrix[i][j-1];
                if(i-1 >=0 && j-1 >= 0)
                    sum-=prefixSumMatrix[i-1][j-1];
                prefixSumMatrix[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = prefixSumMatrix[row2][col2];
        if(row1 - 1 >= 0){
            sum-= prefixSumMatrix[row1-1][col2];
        }
        if(col1-1 >= 0){
            sum-=prefixSumMatrix[row2][col1-1];
        }
        if(row1-1 >=0 && col1-1>=0){
            sum+=prefixSumMatrix[row1-1][col1-1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */