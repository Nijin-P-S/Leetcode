class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int totCount = m*n;
        int numCount = 0;
        
        int delta = 0;
        while(numCount < totCount){
            for(int i=delta; numCount<totCount && i<n-delta; i++){
                numCount++;
                ans.add(matrix[delta][i]);
            }        
            for(int i=delta+1; numCount<totCount && i<m-delta; i++){
                numCount++;
                ans.add(matrix[i][n-delta-1]);
            }
                
            for(int i=n-delta-2;numCount<totCount && i>delta; i--){
                numCount++;
                ans.add(matrix[m-delta-1][i]);
            }
                
            for(int i=m-delta-1;numCount<totCount && i>delta; i--){
                numCount++;
                ans.add(matrix[i][delta]);
            }
            delta++;
        }
        return ans;
    }
}