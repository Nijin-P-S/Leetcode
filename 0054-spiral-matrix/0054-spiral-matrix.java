class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = matrix.length%2 == 0 ? matrix.length/2 : matrix.length/2+1;
        int totCount = matrix.length*matrix[0].length;
        int numCount = 0;
        int index = 0;
        while(numCount < totCount){
            for(int i=index; numCount<totCount && i<n-index; i++){
                numCount++;
                ans.add(matrix[index][i]);
            }        
            for(int i=index+1; numCount<totCount && i<m-index; i++){
                numCount++;
                ans.add(matrix[i][n-index-1]);
            }
                
            for(int i=n-index-2;numCount<totCount && i>index; i--){
                numCount++;
                ans.add(matrix[m-index-1][i]);
            }
                
            for(int i=m-index-1;numCount<totCount && i>index; i--){
                numCount++;
                ans.add(matrix[i][index]);
            }
            count--;
            index++;
        }
        return ans;
    }
}