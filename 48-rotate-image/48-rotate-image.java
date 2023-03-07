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
        int[][] res = new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                res[i][j] = matrix[j][i]; 
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            reverse(res, i, matrix[0].length-1);
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[i][j] = res[i][j]; 
            }
        }
    }
}