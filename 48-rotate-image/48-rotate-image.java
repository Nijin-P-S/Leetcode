class Solution {
    private void reverse(int[][] res, int row, int size){
        int left = 0, right = size;
        
        while(left < right){
            int temp = res[row][left];
            res[row][left] = res[row][right];
            res[row][right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<matrix.length; i++){
            reverse(matrix, i, matrix[0].length-1);
        }
    }
}